package com.example.androidrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/*
Create an assets folder.
Make sure you are on android perspective and then:
right click on "app" folder -> new -> directory -> type assets and select the one that says src/main/assets
Inside the assets folder create the xml file: right click on assets folder -> new -> file -> name your file

the xml looks like this:

<?xml version="1.0"?>

<people>
    <person>
        <firstName>Thanos</firstName>
        <lastName>Moschou</lastName>
    </person>

    <person>
        <firstName>John</firstName>
        <lastName>Georgiou</lastName>
    </person>

    <person>
        <firstName>Alex</firstName>
        <lastName>Athanasiou</lastName>
    </person>

</people>

It has the <?xml version="1.0"?> at the beginning and then it has a root element that matches the name of your file.
In my case people is the root element. Inside it has some child elements

 */


public class XmlParsing extends AppCompatActivity {

    private Button backBtn;
    private TextView firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parsing);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);

        //parse the xml
        try
        {
            parseXml(getAssets());
        }
        catch (ParserConfigurationException e)
        {
            throw new RuntimeException(e);
        }
        catch (SAXException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    private void parseXml(AssetManager assets) throws IOException, ParserConfigurationException, SAXException
    {
        //first create the input stream
        InputStream fileStream = assets.open("people.xml");

        //then create a document builder factory, a document builder and a document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fileStream);

        NodeList list = document.getElementsByTagName("person"); //get all <person> elements

        for(int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i); //get the current <person> node
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                //extract data from inside this node (don't suppose it's a root element)
                String firstNameString = element.getElementsByTagName("firstName").item(0).getTextContent();
                String lastNameString = element.getElementsByTagName("lastName").item(0).getTextContent();

                System.out.println(firstName + " " + lastName);

                if(i == 0)
                {
                    firstName.setText(firstNameString);
                    lastName.setText(lastNameString);
                }
            }
        }


    }
}