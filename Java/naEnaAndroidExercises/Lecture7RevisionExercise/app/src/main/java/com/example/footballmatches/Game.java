package com.example.footballmatches;

public class Game {
    private String match;
    private String homeTeam;
    private String visitorTeam;
    private int homeScore;
    private int visitorScore;

    public Game(String aMatch, String finalScore)
    {
        String[] teams = aMatch.split(" - ");
        this.homeTeam = teams[0];
        this.visitorTeam = teams[1];
        this.match = aMatch;

        String[] score = finalScore.split(" - ");
        this.homeScore = Integer.parseInt(score[0]);
        this.visitorScore = Integer.parseInt(score[1]);
    }

    public String whoWins()
    {
        if(homeScore > visitorScore)
            return homeTeam;
        else if(homeScore < visitorScore)
            return visitorTeam;
        else
            return "Draw";
    }

    public String getHomeTeam()
    {
        return homeTeam;
    }

    public String getVisitorTeam()
    {
        return visitorTeam;
    }

    public String getMatch()
    {
        return this.match;
    }
}
