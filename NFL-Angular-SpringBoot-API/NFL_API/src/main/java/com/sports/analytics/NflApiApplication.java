package com.sports.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NflApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(NflApiApplication.class, args);
    }
}


// GET ALL PLAYERS: http://localhost:8080/players
// GET ALL QBs: http://localhost:8080/players/position?position=QB
// GET PSU PLAYERS: http://localhost:8080/players/college?college=Penn%20State