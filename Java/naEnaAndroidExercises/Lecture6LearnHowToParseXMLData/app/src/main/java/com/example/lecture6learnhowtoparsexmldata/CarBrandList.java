package com.example.lecture6learnhowtoparsexmldata;

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

public class CarBrandList
{
    private List<CarBrand> carBrands;

    public CarBrandList(AssetManager assets) throws IOException, ParserConfigurationException, SAXException
    {
        carBrands = new ArrayList<>();
        fillTheList(assets);
    }

    private void fillTheList(AssetManager assets) throws IOException, ParserConfigurationException, SAXException
    {
        /*
        Change the view from android to project. Then go to main folder, right click, new directory and
        select the assets. Then paste the xml file.
         */
        InputStream fileStream = assets.open("records.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fileStream);

        NodeList list = document.getElementsByTagName("carBrand");

        for(int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i); //get the current <carBrand> node
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                //extract data from inside this node (don't suppose it's a root element)
                String brand = element.getElementsByTagName("name").item(0).getTextContent();
                String models = element.getElementsByTagName("models").item(0).getTextContent();

                carBrands.add(new CarBrand(brand, models));
            }
        }
    }

    public void addBrand(CarBrand brand)
    {
        this.carBrands.add(brand);
    }

    public void addBrandModel(String brand, String model)
    {
        for(CarBrand b : carBrands)
            if(b.isBrandOf(brand))
            {
                b.addModel(model);
                break;
            }
    }

    public List<CarBrand> getCarBrandsAsAList()
    {
        return this.carBrands;
    }

    public List<String> getAllBrandsAsStrings()
    {
        List<String> brands = new ArrayList<>();

        for(CarBrand c : carBrands)
            brands.add(c.getBrandName());

        return brands;
    }

    public List<String> getAllModelsForBrand(String brand)
    {
        List<String> models = null;

        for(CarBrand c : carBrands)
            if(c.isBrandOf(brand))
            {
                models = c.getModelsList();
                break;
            }

        return models;
    }
}
