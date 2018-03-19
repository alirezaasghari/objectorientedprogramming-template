package oop.pset4.luggage_madness.controller.travelstage;

import oop.pset4.luggage_madness.model.Luggage;

import java.time.Duration;

public class TransportCart implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 25 minutes to the processing time

        Duration waitingDuration = luggage.getWaitingDuration();
        Duration processingTime = waitingDuration.plusMinutes(25);
        luggage.setWaitingDuration(processingTime);

        return luggage;
    }
}
