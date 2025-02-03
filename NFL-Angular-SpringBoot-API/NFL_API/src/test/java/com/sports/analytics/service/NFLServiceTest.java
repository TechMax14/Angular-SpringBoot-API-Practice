package com.sports.analytics.service;

import com.sports.analytics.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class NFLServiceTest {

    private NflService nflService;

    @BeforeEach
    public void setup() {
        nflService = new NflService();
    }

    @Test
    public void testLoadPlayersFromCsv() {
        List<Player> players = nflService.loadPlayersFromCsv("src/test/resources/players.csv");

        // Assert that the list is not null and contains data
        assertNotNull(players, "Players list should not be null");
        assertTrue(players.size() > 0, "Players list should contain at least one player");
    }

    @Test
    public void testFindPlayerByCollege() {
        List<Player> players = nflService.loadPlayersFromCsv("src/test/resources/players.csv");
        List<Player> michiganPlayers = nflService.findPlayersByCollege(players, "Michigan");

        // Assert that the list is not empty and contains the right college
        assertNotNull(michiganPlayers, "Michigan players list should not be null");
        assertTrue(michiganPlayers.size() > 0, "There should be Michigan players");
        assertTrue(michiganPlayers.get(0).getCollegeName().equals("Michigan"), "The player should have Michigan as their college");
    }

    @Test
    public void testFindPlayerByPosition() {
        List<Player> players = nflService.loadPlayersFromCsv("src/test/resources/players.csv");
        List<Player> qbPlayers = nflService.findPlayersByPosition(players, "QB");

        // Assert that the list is not empty and contains the right position
        assertNotNull(qbPlayers, "QB players list should not be null");
        assertTrue(qbPlayers.size() > 0, "There should be QB players");
        assertTrue(qbPlayers.get(0).getPosition().equals("QB"), "The player should have QB as their position");
    }
}