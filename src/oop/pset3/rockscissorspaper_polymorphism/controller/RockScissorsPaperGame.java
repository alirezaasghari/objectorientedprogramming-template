package oop.pset3.rockscissorspaper_polymorphism.controller;

import oop.pset3.rockscissorspaper_polymorphism.model.Move;
import oop.pset3.rockscissorspaper_polymorphism.model.Player;
import oop.pset3.rockscissorspaper_polymorphism.model.Result;
import oop.pset3.rockscissorspaper_polymorphism.view.Host;

import java.util.List;

public class RockScissorsPaperGame {

    private Host host = new Host();
    private Judge judge = new Judge();

    public void play() {
        host.sayHi();
        List<Player> players = PlayerFactory.getTwoPlayers();
        boolean theyWantToPlay = true;
        while (theyWantToPlay) {
            playOneRound(players);
            theyWantToPlay = ask(players);
        }
        host.sayGoodbye();
    }

    private void playOneRound(List<Player> players) {
        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);
        Move moveOne = playerOne.getMove();
        Move moveTwo = playerTwo.getMove();
        Result result = judge.getResult(moveOne, moveTwo);
        host.show(result);
    }

    private boolean ask(List<Player> players) {
        return players.stream()
                .allMatch(Player::wantsToPlayAgain);
    }

}

