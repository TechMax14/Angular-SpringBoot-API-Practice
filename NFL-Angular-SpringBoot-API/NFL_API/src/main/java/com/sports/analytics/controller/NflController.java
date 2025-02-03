package com.sports.analytics.controller;

import com.sports.analytics.service.NflService;
import com.sports.analytics.model.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NflController {

    private final NflService nflService;

    public NflController(NflService nflService) {
        this.nflService = nflService;
    }

    // Load players from CSV
    private List<Player> loadPlayers() {
        // You should provide the file path of your CSV here
        String filePath = "src/main/resources/players.csv";  // Update this with the actual file path
        return nflService.loadPlayersFromCsv(filePath);
    }

    // Endpoint to get all players
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        List<Player> players = loadPlayers();  // Load players from the CSV
        return players;
    }

    // Endpoint to get players by position
    @GetMapping("/players/position")
    public List<Player> getPlayersByPosition(@RequestParam String position) {
        List<Player> players = loadPlayers();  // Load players from the CSV
        return nflService.findPlayersByPosition(players, position);  // Filter by position
    }

    // Endpoint to get players by college name
    @GetMapping("/players/college")
    public List<Player> getPlayersByCollege(@RequestParam String college) {
        List<Player> players = loadPlayers();  // Load players from the CSV
        return nflService.findPlayersByCollege(players, college);  // Filter by college name
    }
}
