package oop.pset2.rockscissorspaper.model;

public class WinnerItem {
    private MoveType moveOne;
    private MoveType moveTwo;

    public WinnerItem(MoveType moveOne, MoveType moveTwo) {
        this.moveOne = moveOne;
        this.moveTwo = moveTwo;
    }

    public MoveType getMoveOne() {
        return moveOne;
    }

    public MoveType getMoveTwo() {
        return moveTwo;
    }
}
