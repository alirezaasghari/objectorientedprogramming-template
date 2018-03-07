package oop.pset3.rockscissorspaper_polymorphism.model;

public class  Rock implements Move {

    @Override
    public MoveType getType() {
        return MoveType.ROCK;
    }

    @Override
    public boolean defeats(Move move) {
        return move.getType().equals(MoveType.SCISSORS);
    }
}
