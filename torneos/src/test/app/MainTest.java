package test.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import net.app.entities.Player;
import net.app.entities.TournamentManager;
import net.app.entities.Tourney;
import net.app.entities.utilities.Status;
import net.app.exceptions.PlayerExistsException;
import net.app.exceptions.TourneyExistsException;
import net.app.exceptions.matchException.MatchIsFinishedException;
import net.app.exceptions.matchException.MatchIsInactiveException;
import net.app.interfaces.IMatch;
import net.app.interfaces.IPlayer;
import net.app.interfaces.ITournamentManager;
import net.app.interfaces.ITourney;

@DisplayName("Testing tournament making")
@TestMethodOrder(OrderAnnotation.class)
public class MainTest {
    static IPlayer player1;
    static IPlayer player2;
    List<IMatch> matches;
    static ITourney tourney;
    static ITournamentManager tournamentManager;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final String UNNECESARY_EXCEPTION = "Unnecesary exception throwed";

    @BeforeAll
    static void setUp() {
        player1 = new Player("Pedro");
        player2 = new Player("Pablo");
        tourney = new Tourney("Tenis");
        tournamentManager = new TournamentManager();
    }

    @Test
    @Order(1)
    @DisplayName("Players")
    public void playersTest() {
        assertDoesNotThrow(() -> {
            tourney.addPlayer(player1);
            tourney.addPlayer(player2);
        }, UNNECESARY_EXCEPTION);

        assertThrows(PlayerExistsException.class, () -> tourney.addPlayer(player1),
                "Repeated player is not throwing an exception");

        assertEquals("Player1 name is wrong", player1.getName(), "Pedro");
        assertEquals("Player2 name is wrong", player2.getName(), "Pablo");
        Set<IPlayer> players = tourney.getPlayers();
        assertTrue("Tourney is not adding players correctly", players.contains(player1) && players.contains(player2));
        assertEquals("Player initial score is wrong", player1.getTotalScore(), 0);
        player1.incrementTotalScore();
        assertEquals("Player is not increasing its score correctly", player1.getTotalScore(), 1);
        player1.decrementTotalScore();
        assertEquals("Player is not decreasing its score correctly", player1.getTotalScore(), 0);
    }

    @Test
    @Order(2)
    @DisplayName("Tourneys and matches")
    public void tourneysTest() {
        assertEquals(tourney.getName(), "Tenis");
        tourney.generateMatches();
        matches = tourney.getMatches();
        assertTrue("Tourneys is not adding matches correctly", matches.size() == 1);
        System.setOut(new PrintStream(outContent));
        tourney.printScheduling();
        assertFalse("Tourney schedule is empty on printing", outContent.toString().isEmpty());
        System.setOut(originalOut);
        outContent = new ByteArrayOutputStream();
    }

    @Test
    @Order(3)
    @DisplayName("Only Matches")
    public void matchesTest() {
        IMatch match = matches.get(0);
        assertEquals(Status.INACTIVE, match.getStatus());
        assertThrows(MatchIsInactiveException.class, () -> match.addScore(player1),
                "Adding a score to an INACTIVE match needs to thorw MatchIsInactiveException");
        match.setStatus(Status.ACTIVE);
        assertEquals(Status.ACTIVE, match.getStatus());
        assertDoesNotThrow(() -> match.addScore(player1), UNNECESARY_EXCEPTION);
        assertTrue("Match is not adding scores correctly to the map",
                match.getScores().containsKey(player1) && match.getScores().get(player1) == 1);
        match.setStatus(Status.FINISHED);
        assertEquals(Status.FINISHED, match.getStatus());
        assertThrows(MatchIsFinishedException.class, () -> match.addScore(player1),
                "Adding a score to a FINISHED match needs to thorw MatchIsFinishedException");
    }

    @Test
    @Order(4)
    @DisplayName("Tournament manager")
    public void tournamentManagerTest() {
        assertDoesNotThrow(() -> tournamentManager.addTourney(tourney), UNNECESARY_EXCEPTION);
        assertThrows(TourneyExistsException.class, () -> tournamentManager.addTourney(tourney),
                "Tourney already exists, it needs to throw TourneyExistsException");
        List<ITourney> tourneys = tournamentManager.getTourneys();
        assertTrue("Tournament Manager is not adding tourneys correctly", tourneys.size() == 1);
        assertEquals("Tourney added wrong on TournamentManager", tourney, tourneys.get(0));
    }

}
