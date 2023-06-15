package net.app.interfaces;

import java.util.Map;

import net.app.entities.utilities.Status;
import net.app.exceptions.matchException.MatchException;

public interface IMatch {
    IPlayer getPlayer1();

    IPlayer getPlayer2();

    Status getStatus();

    void setStatus(Status status);

    Map<IPlayer, Integer> getScores();

    void addScore(IPlayer player) throws MatchException;
}
