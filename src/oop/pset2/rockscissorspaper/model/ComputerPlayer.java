package oop.pset2.rockscissorspaper.model;

import oop.pset2.rockscissorspaper.controller.MoveFactory;

import java.util.Collections;
import java.util.List;

public class ComputerPlayer implements Player {

    @Override
    public Move getMove() {
        List<Move> computerMove = new MoveFactory().makeMoves();
        Collections.shuffle(computerMove);
        Move firstMove = computerMove.get(0);
        return firstMove;
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
