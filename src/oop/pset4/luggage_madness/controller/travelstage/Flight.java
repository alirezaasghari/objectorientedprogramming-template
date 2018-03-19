package oop.pset4.luggage_madness.controller.travelstage;

import oop.pset4.luggage_madness.model.Luggage;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add travel duration to the processing time

        Duration waitingDuration = luggage.getWaitingDuration();
        Duration flightDuration = luggage.getFlightDuration();
        Duration processingTime = waitingDuration.plus(flightDuration);
        luggage.setWaitingDuration(processingTime);

        // Update arrival time
        LocalDateTime departureTime = luggage.getDepartureTime();
        LocalDateTime arrivalTime = departureTime.plus(flightDuration);
        luggage.setArrivalTime(arrivalTime);

        return luggage;
    }
}
