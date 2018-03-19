package oop.pset4.luggage_madness;

import oop.pset4.luggage_madness.controller.Airport;
import oop.pset4.luggage_madness.model.Luggage;
import oop.pset4.luggage_madness.parse.LuggageParser;

import java.util.List;

public class Pset4Main {

    public static void main(String[] args) {
        LuggageParser luggageParser = new LuggageParser();
        List<Luggage> departureLuggage = luggageParser.asList("src/oop/pset4/luggage_madness/data/luggage.csv");

        Airport airport = new Airport();
        List<Luggage> arrivalLuggage = airport.travel(departureLuggage);

        // Returning the list of arrival luggage will be very useful
        // when we learn about unit testing to be able to test the behaviour
        // of the Airport class automatically
    }
}
