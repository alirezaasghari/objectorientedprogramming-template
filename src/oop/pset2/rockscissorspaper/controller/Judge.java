package oop.pset2.rockscissorspaper.controller;

import oop.pset2.rockscissorspaper.model.Move;
import oop.pset2.rockscissorspaper.model.MoveType;
import oop.pset2.rockscissorspaper.model.Result;
import oop.pset2.rockscissorspaper.model.WinnerItem;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Judge {

    public Result getResult(Move moveOne, Move moveTwo) {
        Result result = new Result();
        result.setPlayer1move(moveOne);
        result.setPlayer2move(moveTwo);
        result.setWinner(getWinner(moveOne, moveTwo));
        return result;
    }

    private String getWinner(Move moveOne, Move moveTwo) {

        if (moveOne.getType().equals(moveTwo.getType()))
            return "Draw.";
        if (playerOneWins(moveOne, moveTwo))
            return "Player 1 Wins.";

        return "Player 2 Wins.";
    }

    private boolean playerOneWins(Move moveOne, Move moveTwo) {
        return Stream.of(
                new WinnerItem(MoveType.ROCK, MoveType.SCISSORS),
                new WinnerItem(MoveType.SCISSORS, MoveType.PAPER),
                new WinnerItem(MoveType.PAPER, MoveType.ROCK))
                .collect(Collectors.toSet())
                .stream()
                .anyMatch(e -> e.getMoveOne() == moveOne.getType() && e.getMoveTwo() == moveTwo.getType());
    }
}



