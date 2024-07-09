package com.example.thema_3;

import android.content.res.AssetManager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ChampionsList {
    private List<Champion> champions;

    public ChampionsList(AssetManager assetManager) throws IOException, ParserConfigurationException, SAXException {
        this.champions = new ArrayList<>();

        InputStream is = assetManager.open("champions.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);

        NodeList nodeList = document.getElementsByTagName("champion");
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                String name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                String year = element.getElementsByTagName("year").item(0).getChildNodes().item(0).getNodeValue();
                String logo = element.getElementsByTagName("url").item(0).getChildNodes().item(0).getNodeValue();

                Champion champ = new Champion(name, year, logo);
                champions.add(champ);
            }
        }
    }

    public List<Champion> getChampions()
    {
        return champions;
    }

    public Champion getChampionByYear(String aYear)
    {
        for(Champion c : champions)
            if(c.hasYear(aYear))
                return c;
        return null;
    }
}
