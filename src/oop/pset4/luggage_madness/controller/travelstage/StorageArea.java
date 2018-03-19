package oop.pset4.luggage_madness.controller.travelstage;

import oop.pset4.luggage_madness.model.Luggage;

import java.time.Duration;
import java.time.LocalDateTime;

public class StorageArea implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add as much duration to the processing time as the departure time minus 30 minutes

        LocalDateTime dropOff = luggage.getDropOffTime();
        LocalDateTime departure = luggage.getDepartureTime();
        LocalDateTime boarding = getBoardingTime(departure);
        Duration waitingDuration = luggage.getWaitingDuration();

        // if 30 minutes is not possible, the luggage won't be stored at all, which means that
        // no waiting time will be added at all
        if (isWaitingFor(boarding, dropOff)) {
            Duration duration = Duration.between(dropOff.plus(waitingDuration), boarding);
            Duration processingTime = waitingDuration.plus(duration);
            luggage.setWaitingDuration(processingTime);
        }

        return luggage;
    }

    private boolean isWaitingFor(LocalDateTime boarding, LocalDateTime dropOff) {
        return dropOff.isBefore(boarding);
    }

    private LocalDateTime getBoardingTime(LocalDateTime departure) {
        return departure.minusMinutes(30);
    }

}
