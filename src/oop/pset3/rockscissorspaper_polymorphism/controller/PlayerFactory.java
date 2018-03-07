package oop.pset3.rockscissorspaper_polymorphism.controller;

import oop.pset3.rockscissorspaper_polymorphism.model.ComputerPlayer;
import oop.pset3.rockscissorspaper_polymorphism.model.HumanPlayer;
import oop.pset3.rockscissorspaper_polymorphism.model.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerFactory {

    public static List<Player> getTwoPlayers() {
        return Stream.of(
                new HumanPlayer(),
                new ComputerPlayer())
                .collect(Collectors.toList());
    }
}
