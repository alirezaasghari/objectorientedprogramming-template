package oop.pset4.luggage_madness.controller;

import oop.pset4.luggage_madness.model.Luggage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SecurityControl {

    private List<Luggage> rejectedLuggage = new ArrayList<>();

    public boolean isAllowedToTravel(Luggage luggage) {
        // validate that the luggage arrived at least 30 minutes before departure time
        // counting between the drop off time and the departure time
        // remember the luggage that has been rejected in order to facilitate it later on

        LocalDateTime boarding = getBoardingTime(luggage);
        if (isLateFor(boarding, luggage)) {
            reject(luggage);
            return false;
        }
        return true;

    }

    private LocalDateTime getBoardingTime(Luggage luggage) {
        LocalDateTime departure = luggage.getDepartureTime();
        return departure.minusMinutes(30);
    }

    private boolean isLateFor(LocalDateTime boarding, Luggage luggage) {
        LocalDateTime dropOff = luggage.getDropOffTime();
        return dropOff.isAfter(boarding);
    }

    private void reject(Luggage luggage) {
        rejectedLuggage.add(luggage);
    }

    public List<Luggage> getRejectedLuggage() {
        return rejectedLuggage;
    }
}
