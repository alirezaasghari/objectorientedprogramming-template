package oop.pset4.luggage_madness.controller.travelstage;

import oop.pset4.luggage_madness.model.Luggage;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add travel duration to the processing time

        updateFlightDuration(luggage);
        updateArrivalTime(luggage);
        return luggage;
    }

    private void updateFlightDuration(Luggage luggage) {
        Duration waitingDuration = luggage.getWaitingDuration();
        Duration flightDuration = luggage.getFlightDuration();
        Duration processingTime = waitingDuration.plus(flightDuration);
        luggage.setWaitingDuration(processingTime);
    }

    private void updateArrivalTime(Luggage luggage) {
        LocalDateTime departureTime = luggage.getDepartureTime();
        Duration flightDuration = luggage.getFlightDuration();
        LocalDateTime arrivalTime = departureTime.plus(flightDuration);
        luggage.setArrivalTime(arrivalTime);
    }
}
