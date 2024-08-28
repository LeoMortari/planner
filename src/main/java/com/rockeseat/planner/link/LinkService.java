package com.rockeseat.planner.link;

import com.rockeseat.planner.activity.ActivityData;
import com.rockeseat.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    public LinkResponse saveLink(LinkRequestPayload link, Trip trip) {
        Link newLink = new Link(link.title(), link.url(), trip);

        this.linkRepository.save(newLink);

        return new LinkResponse(newLink.getId());
    }

    public List<LinkData> getAllActivitiesFromId(UUID tripId) {
    return this.linkRepository.findByTripId(tripId).stream().map(link -> new LinkData(link.getId(), link.getTitle(), link.getUrl())).toList();
    }

}
