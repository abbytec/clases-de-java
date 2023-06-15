package interfaces;

import java.util.Map;

import entities.utilities.Status;

public interface Match {
    Player getPlayer1();

    Player getPlayer2();

    Status getStatus();

    Map<Player, Integer> getScores();

    void addScore(Player player);
}
