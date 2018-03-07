package oop.pset3.rockscissorspaper_polymorphism.model;

import oop.pset3.rockscissorspaper_polymorphism.controller.MoveFactory;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {

    Scanner scanner = new Scanner(System.in);

    @Override
    public Move getMove() {
        List<Move> moves = new MoveFactory().makeMoves();
        System.out.print("Write your move (ROCK, SCISSORS, PAPER): ");
        String humanMove = scanner.nextLine();
        return toHumanMove(humanMove, moves);
    }

    private Move toHumanMove(String humanMove, List<Move> moves) {
        return moves.stream()
                .filter(move -> move.getType().toString().equalsIgnoreCase(humanMove))
                .findFirst().get();
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.print("Do you want to play again? (y/n): ");
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("y");
    }

}
