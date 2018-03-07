package oop.pset3.rockscissorspaperlizardspock_polymorphism.view;

import oop.pset3.rockscissorspaperlizardspock_polymorphism.model.Result;

public class Host {
    public void sayHi() {
        System.out.println("Host: Welcome to the Rock, Scissors, Paper, Lizard, Spock tournament!");
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
