package oop.pset3.rockscissorspaper_polymorphism.model;

public class Paper implements Move {

    @Override
    public MoveType getType() {
        return MoveType.PAPER;
    }

    @Override
    public boolean defeats(Move move) {
        return move.getType().equals(MoveType.ROCK);
    }
}
