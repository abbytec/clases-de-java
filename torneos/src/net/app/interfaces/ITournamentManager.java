package net.app.interfaces;

import java.util.List;

import net.app.exceptions.TourneyExistsException;
import net.app.exceptions.TourneyNotFoundException;

public interface ITournamentManager {
    void addTourney(ITourney tourney) throws TourneyExistsException;

    void removeTourney(ITourney tourney) throws TourneyNotFoundException;

    List<ITourney> getTourneys();
}
