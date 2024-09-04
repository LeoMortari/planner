package com.rockeseat.planner.trip;

import com.rockeseat.planner.participant.Participant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "trips")
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false, name = "starts_at")
    private LocalDateTime startsAt;

    @Column(nullable = false, name = "ends_at")
    private LocalDateTime endsAt;

    @Column(nullable = false, name = "is_confirmed")
    private Boolean isConfimed;

    @Column(nullable = false, name = "owner_name")
    private String ownerName;

    @Column(nullable = false, name = "owner_email")
    private String ownerEmail;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participant> participants;

    public Trip(TripRequestPayload data){
        this.destination = data.destination();
        this.isConfimed = false;
        this.ownerEmail = data.owner_email();
        this.ownerName = data.owner_name();
        this.startsAt = LocalDateTime.parse(data.starts_at(), DateTimeFormatter.ISO_DATE_TIME);
        this.endsAt = LocalDateTime.parse(data.ends_at(), DateTimeFormatter.ISO_DATE_TIME);

    }
}
