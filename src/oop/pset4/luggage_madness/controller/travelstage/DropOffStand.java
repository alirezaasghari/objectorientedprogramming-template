package oop.pset4.luggage_madness.controller.travelstage;

import oop.pset4.luggage_madness.model.Luggage;

import java.time.Duration;

public class DropOffStand implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 10 minutes to the processing time

        Duration waitingDuration = luggage.getWaitingDuration();
        Duration processingTime = waitingDuration.plusMinutes(10);
        luggage.setWaitingDuration(processingTime);

        return luggage;
    }
}