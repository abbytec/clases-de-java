package interfaces;

import java.util.List;

import exceptions.PlayerOnActiveMatch;

public interface Tourney {

    // TODO: El constructor debe crear los matchs de manera completamente aleatoria

    void addPlayer(Player p);

    void removePlayer(Player p) throws PlayerOnActiveMatch;

    List<Match> getMatchs();

    void switchPlayers();

    void switchPlayers(Player p1, Player p2) throws PlayerOnActiveMatch;

    void printScheduling();
}
