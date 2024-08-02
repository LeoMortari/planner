package com.rockeseat.planner.participant;

import com.rockeseat.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip){
        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip)).toList();

        participantRepository.saveAll(participants);

        System.out.println(participants.getFirst().getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId){

    }
}
