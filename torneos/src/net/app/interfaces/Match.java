package net.app.interfaces;

import java.util.Map;

import net.app.entities.utilities.Status;

public interface Match {
    Player getPlayer1();

    Player getPlayer2();

    Status getStatus();

    Map<Player, Integer> getScores();

    void addScore(Player player);
}
