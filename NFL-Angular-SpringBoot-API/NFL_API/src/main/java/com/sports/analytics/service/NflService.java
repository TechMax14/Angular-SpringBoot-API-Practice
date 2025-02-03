package com.sports.analytics.service;

import com.sports.analytics.model.Player;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NflService {

    // Load players from a CSV file
    public List<Player> loadPlayersFromCsv(String filePath) {
        List<Player> players = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (String[] record : records) {
                if (record[0].equals("nflId")) continue; // Skip header row
                Player player = new Player(
                        Integer.parseInt(record[0]),
                        record[1],
                        Integer.parseInt(record[2]),
                        record[3],
                        record[4],
                        record[5],
                        record[6]
                );
                players.add(player);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return players;
    }

    // Find players by college name
    public List<Player> findPlayersByCollege(List<Player> players, String collegeName) {
        List<Player> result = new ArrayList<>();
        for (Player player : players) {
            if (player.getCollegeName().equalsIgnoreCase(collegeName)) {
                result.add(player);
            }
        }
        return result;
    }

    // Find players by position
    public List<Player> findPlayersByPosition(List<Player> players, String position) {
        List<Player> result = new ArrayList<>();
        for (Player player : players) {
            if (player.getPosition().equalsIgnoreCase(position)) {
                result.add(player);
            }
        }
        return result;
    }
}
