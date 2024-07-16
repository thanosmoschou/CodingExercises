package com.example.ics22020;

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

public class SurgeonList {
    ArrayList<Surgeon> suList;

    public SurgeonList(AssetManager assets) throws IOException, ParserConfigurationException, SAXException {
        suList = new ArrayList<>();

        InputStream inputStream = assets.open("records.xml");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);

        NodeList list = document.getElementsByTagName("doctor");
        for(int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                String specialization = element.getElementsByTagName("specialization").item(0).getChildNodes().item(0).getNodeValue();
                String[] successArray = element.getElementsByTagName("success").item(0).getChildNodes().item(0).getNodeValue().split(", ");

                Surgeon surg = new Surgeon(specialization);
                for(String s : successArray) {
                    surg.addSuccess(Integer.parseInt(s));
                }

                suList.add(surg);
            }
        }
    }

    public List<Surgeon> getSurgeons() {
        return this.suList;
    }

    public String findPercentage(String speciality) {
        Surgeon selected = null;

        for(Surgeon s : suList)
            if(s.hasSpecialization(speciality))
                selected = s;

        if(selected != null)
            return Double.toString(selected.calcSuccessRate());

        return null;
    }
}

