package com.example.footballmatches;

import android.content.res.AssetManager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class GameList {
    private ArrayList<Game> games;
    private int gameCtr;

    public GameList(AssetManager assets)
    {
        this.games = new ArrayList<>();

        try
        {
            //parse the xml
            InputStream input = assets.open("games.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(input);

            NodeList nodeList = document.getElementsByTagName("game");
            for(int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) //check if is a node that we can manipulate
                {
                    Element elementNode = (Element) node;

                    String aMatch = elementNode.getElementsByTagName("teams").item(0).getTextContent();
                    String finalScore = elementNode.getElementsByTagName("score").item(0).getTextContent();

                    games.add(new Game(aMatch, finalScore));
                }
            }

        }
        catch (ParserConfigurationException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        catch (SAXException e)
        {
            throw new RuntimeException(e);
        }


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
