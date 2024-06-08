package com.example.myapplication;

import java.util.ArrayList;

public class GameList {
    private ArrayList<Game> games;
    private int gameCtr;

    public GameList()
    {
        this.games = new ArrayList<>();
        games.add(new Game("Hearts - PAOK", 1, 2));
        games.add(new Game("Olympiakos - Cukaricki", 3, 1));
        games.add(new Game("Antwerp - AEK", 1, 0));
        games.add(new Game("Braga - Panathinaikos", 2, 1));
        games.add(new Game("Barcelona - Real Madrid", 2, 2));

        gameCtr = -1;
    }

    public String showNextMatch()
    {
        this.gameCtr = (this.gameCtr + 1) % games.size(); //to return to the first match if we reach the end
        String match = games.get(gameCtr).getMatch();
        return match;
    }

    public Game getGame()
    {
        return games.get(gameCtr);
    }
}
