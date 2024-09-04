package com.rockeseat.planner.participant;

import com.rockeseat.planner.trip.Trip;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "participants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "is_confirmed")
    private Boolean isConfimed;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    public Participant(UUID id, String name, String email, Boolean isConfimed){
        this.id = id;
        this.name = name;
        this.email = email;
        this.isConfimed = isConfimed;
    }

    public Participant(String email, Trip trip) {
        this.email = email;
        this.trip = trip;
        this.isConfimed = false;
        this.name  = "";
    }
}
