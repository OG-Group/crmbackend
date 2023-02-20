package com.argroupcrm.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
//        try {
//            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//            // root elements
//            Document doc = docBuilder.newDocument();
//            Element rootElement = doc.createElement("feed");
//            doc.appendChild(rootElement);
//            //feed version
//            Element feedVersion = doc.createElement("feed_version");
//            feedVersion.appendChild(doc.createTextNode("2"));
//            rootElement.appendChild(feedVersion);
//
//            Element object = doc.createElement("object");
//            rootElement.appendChild(object);
//
//            Element category = doc.createElement("Category");
//            category.appendChild(doc.createTextNode("t"));
//            object.appendChild(category);
//
//            Element auction = doc.createElement("Auction");
//            Element bet = doc.createElement("Bet");
//            bet.appendChild(doc.createTextNode("bet"));
//
//            auction.appendChild(bet);
//            object.appendChild(auction);
//
//            Element coordinates = doc.createElement("Coordinates");
//            Element lat = doc.createElement("Lat");
//            Element lng = doc.createElement("Lng");
//            lat.appendChild(doc.createTextNode("lng"));
//            lng.appendChild(doc.createTextNode("lat"));
//
//            coordinates.appendChild(lat);
//            coordinates.appendChild(lng);
//            object.appendChild(coordinates);
//            // write the content into xml file
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(doc);
//            StreamResult result = new StreamResult(new File("file.xml"));
//
//            transformer.transform(source, result);
//            System.out.println("File saved!");
//
//        } catch (ParserConfigurationException pce) {
//            pce.printStackTrace();
//        } catch (TransformerException tfe) {
//            tfe.printStackTrace();
//        }
    }

}
