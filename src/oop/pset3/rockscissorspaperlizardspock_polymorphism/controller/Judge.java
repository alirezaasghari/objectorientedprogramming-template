package oop.pset3.rockscissorspaperlizardspock_polymorphism.controller;

import oop.pset3.rockscissorspaperlizardspock_polymorphism.model.Move;
import oop.pset3.rockscissorspaperlizardspock_polymorphism.model.Result;

public class Judge {


    public Result getResult(Move moveOne, Move moveTwo) {
        Result result = new Result();
        result.setPlayer1move(moveOne);
        result.setPlayer2move(moveTwo);
        result.setWinner(getTheWinner(moveOne, moveTwo));
        return result;
    }

    private String getTheWinner(Move moveOne, Move moveTwo) {

        if (moveOne.defeats(moveTwo)) {
            return "Player 1 Wins.";
        }
        if (moveTwo.defeats(moveOne)) {
            return "Player 2 Wins.";
        }
        return "Draw";

    }

}



