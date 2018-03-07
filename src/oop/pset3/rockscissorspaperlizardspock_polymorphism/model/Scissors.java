package oop.pset3.rockscissorspaper_polymorphism.model;

public class Scissors implements Move {

    @Override
    public MoveType getType() {
        return MoveType.SCISSORS;
    }

    @Override
    public boolean defeats(Move move) {
        return move.getType().equals(MoveType.PAPER);
    }
}
