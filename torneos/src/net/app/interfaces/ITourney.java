package net.app.interfaces;

import java.util.List;
import java.util.Set;

import net.app.exceptions.PlayerExistsException;
import net.app.exceptions.PlayerNotExistsException;
import net.app.exceptions.PlayerIsOnAMatchException;

public interface ITourney {

    String getName();

    void addPlayer(IPlayer p) throws PlayerExistsException;

    Set<IPlayer> getPlayers();

    void removePlayer(IPlayer p) throws PlayerIsOnAMatchException, PlayerNotExistsException;

    void generateMatches();

    List<IMatch> getMatches();

    void switchPlayers();

    void switchPlayers(IPlayer p1, IPlayer p2) throws PlayerIsOnAMatchException;

    void printScheduling();
}
