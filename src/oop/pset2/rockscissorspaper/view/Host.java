package oop.pset2.rockscissorspaper.view;

import oop.pset2.rockscissorspaper.model.Result;

public class Host {
    public void sayHi() {
        System.out.println("Welcome to the Rock, Scissors, Paper tournament!");
    }

    public void show(Result result) {

        System.out.println("The result of this round is... !");
        System.out.println("Player 1 move: " + result.getPlayer1move().getType());
        System.out.println("Player 2 move: " + result.getPlayer2move().getType());
        System.out.println(result.getWinner());
    }

    public void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}
