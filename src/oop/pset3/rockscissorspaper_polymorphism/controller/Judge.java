package oop.pset2.rockscissorspaper.controller;

import oop.pset2.rockscissorspaper.model.Move;
import oop.pset2.rockscissorspaper.model.MoveType;
import oop.pset2.rockscissorspaper.model.Result;

import java.util.HashMap;

public class Judge {

    private HashMap<MoveType, MoveType> winningMoves;

    public Judge() {
        winningMoves = new HashMap<>();
        winningMoves.put(MoveType.ROCK, MoveType.SCISSORS);
        winningMoves.put(MoveType.SCISSORS, MoveType.PAPER);
        winningMoves.put(MoveType.PAPER, MoveType.ROCK);
    }

    public Result getResult(Move moveOne, Move moveTwo) {
        Result result = new Result();
        result.setPlayer1move(moveOne);
        result.setPlayer2move(moveTwo);
        result.setWinner(getTheWinner(moveOne, moveTwo));
        return result;
    }

    private String getTheWinner(Move moveOne, Move moveTwo) {

        if (moveOne.getType().equals(moveTwo.getType()))
            return "Draw.";
        if (playerOneWins(moveOne, moveTwo))
            return "Player 1 Wins.";

        return "Player 2 Wins.";
    }

    private boolean playerOneWins(Move moveOne, Move moveTwo) {
        MoveType winningMove = winningMoves.get(moveOne.getType());
        return winningMove.equals(moveTwo.getType());
    }
}



