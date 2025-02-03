package com.sports.analytics.model;

public class Player {
    private int nflId;
    private String height;
    private int weight;
    private String birthDate;
    private String collegeName;
    private String position;
    private String displayName;

    // Constructor
    public Player(int nflId, String height, int weight, String birthDate, String collegeName, String position, String displayName) {
        this.nflId = nflId;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.collegeName = collegeName;
        this.position = position;
        this.displayName = displayName;
    }

    // Getters
    public int getNflId() {
        return nflId;
    }

    public String getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getPosition() {
        return position;
    }

    public String getDisplayName() {
        return displayName;
    }
}
