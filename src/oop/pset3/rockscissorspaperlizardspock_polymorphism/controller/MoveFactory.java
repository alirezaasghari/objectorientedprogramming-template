package oop.pset3.rockscissorspaper_polymorphism.controller;

import oop.pset3.rockscissorspaper_polymorphism.model.Move;
import oop.pset3.rockscissorspaper_polymorphism.model.Paper;
import oop.pset3.rockscissorspaper_polymorphism.model.Rock;
import oop.pset3.rockscissorspaper_polymorphism.model.Scissors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveFactory {

    public List<Move> makeMoves() {
        return Stream.of(
                new Rock(),
                new Scissors(),
                new Paper())
                .collect(Collectors.toList());
    }
}
