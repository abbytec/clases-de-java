package interfaces;

import java.util.List;

import exceptions.TourneyNotFoundException;

public interface TournamentManager {
    void addTourney(Tourney tourney);

    void removeTourney(Tourney tourney) throws TourneyNotFoundException;

    List<Tourney> getTourneys();
}
