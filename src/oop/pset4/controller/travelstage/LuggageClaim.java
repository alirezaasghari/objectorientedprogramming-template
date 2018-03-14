package oop.pset4.controller.travelstage;

import oop.pset4.model.Luggage;

import java.time.Duration;

public class LuggageClaim implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 15 minutes to the processing time

        Duration waitingDuration = luggage.getWaitingDuration();
        Duration processingTime = waitingDuration.plusMinutes(15);
        luggage.setWaitingDuration(processingTime);

        return luggage;
    }
}
