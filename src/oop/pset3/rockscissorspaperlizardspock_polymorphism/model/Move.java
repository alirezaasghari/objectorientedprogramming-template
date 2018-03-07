package oop.pset3.rockscissorspaper_polymorphism.model;

public interface Move {

    MoveType getType();

    boolean defeats(Move move);
}
