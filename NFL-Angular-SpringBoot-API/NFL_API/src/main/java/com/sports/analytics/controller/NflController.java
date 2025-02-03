package com.sports.analytics.controller;

import com.sports.analytics.service.NflService;
import com.sports.analytics.model.Player;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular frontend to access API
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
        return loadPlayers();
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

    // ✅ New Endpoint: Get unique positions
    @GetMapping("/positions")
    public Set<String> getAllPositions() {
        return loadPlayers().stream()
                .map(Player::getPosition)
                .filter(position -> position != null && !position.isEmpty())
                .collect(Collectors.toSet());
    }

    // ✅ New Endpoint: Get unique colleges
    @GetMapping("/colleges")
    public Set<String> getAllColleges() {
        return loadPlayers().stream()
                .map(Player::getCollegeName)
                .filter(college -> college != null && !college.isEmpty())
                .collect(Collectors.toSet());
    }

    // Endpoint to get players filtered by position and/or college
    @GetMapping("/players/filter")
    public List<Player> getPlayersByFilters(
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String college) {

        List<Player> players = loadPlayers();  // Load players from CSV

        // Apply filters only if parameters are provided
        if (position != null && !position.isEmpty()) {
            players = nflService.findPlayersByPosition(players, position);
        }
        if (college != null && !college.isEmpty()) {
            players = nflService.findPlayersByCollege(players, college);
        }

        return players;
    }
}
