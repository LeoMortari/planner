package com.rockeseat.planner.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/{id}/confirm")
    public ResponseEntity<Participant> confirmParticipant(@PathVariable UUID id, @RequestBody ParticipantRequestPayload payload) {
        Optional<Participant> participant = this.participantRepository.findById(id);

        if(participant.isPresent()) {
            Participant raw = participant.get();

            raw.setIsConfimed(true);
            raw.setName(payload.name());

            this.participantRepository.save(raw);

            return ResponseEntity.ok(raw);
        }

        return ResponseEntity.notFound().build();
    }

}
