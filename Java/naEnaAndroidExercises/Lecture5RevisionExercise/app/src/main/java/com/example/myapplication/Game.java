package com.example.myapplication;

public class Game {
    private String match;
    private int homeScore;
    private int visitorScore;

    public Game(String aMatch, int aHomeScore, int aVisitorScore)
    {
        this.match = aMatch;
        this.homeScore = aHomeScore;
        this.visitorScore = aVisitorScore;
    }

    public String whoWins()
    {
        String[] teams = match.split(" - ");

        if(homeScore > visitorScore)
            return "The winner is ... " + teams[0];
        else if(homeScore < visitorScore)
            return "The winner is ... " + teams[1];
        else
            return "Draw";
    }

    public String getMatch()
    {
        return this.match;
    }
}
