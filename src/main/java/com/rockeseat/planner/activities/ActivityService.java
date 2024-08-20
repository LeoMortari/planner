package com.rockeseat.planner.activities;

import com.rockeseat.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository repository;

    public ActivityResponse saveActivity(ActivityRequestPayload activity, Trip trip) {
        Activity newActivity = new Activity(activity.title(), activity.occours_at(), trip);

        this.repository.save(newActivity);

        return new ActivityResponse(newActivity.getId());
    }
}
