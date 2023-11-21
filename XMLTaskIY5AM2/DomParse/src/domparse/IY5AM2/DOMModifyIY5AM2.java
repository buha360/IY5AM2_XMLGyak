package domparse.IY5AM2;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.File;

public class DOMModifyIY5AM2 {

    public static void main(String[] argv) {
        try {
            File inputFile = new File("M:\\Egyetem\\IY5AM2_XMLGyak\\XMLTaskIY5AM2\\IY5AM2XML.xml");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            modifyDrivers(doc);
            modifyCars(doc);
            modifyCustomers(doc);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            System.out.println("Valami baj van: " + e);
        }
    }

    // Driver elemeket módosító metódus
    private static void modifyDrivers(Document doc) {
        NodeList driverList = doc.getElementsByTagName("Driver");
        for (int i = 0; i < driverList.getLength(); i++) {
            Node driver = driverList.item(i);
            Element eElement = (Element) driver;
            String phoneNumber = eElement.getElementsByTagName("phone_number").item(0).getTextContent();
            eElement.getElementsByTagName("phone_number").item(0).setTextContent("MODIFIED_" + phoneNumber);
        }
    }

    // Cars elemeket módosító metódus
    private static void modifyCars(Document doc) {
        NodeList carsList = doc.getElementsByTagName("Cars");
        for (int i = 0; i < carsList.getLength(); i++) {
            Node car = carsList.item(i);
            Element eElement = (Element) car;
            if ("Available".equals(eElement.getElementsByTagName("car_status").item(0).getTextContent())) {
                eElement.getElementsByTagName("car_status").item(0).setTextContent("Unavailable");
            }
        }
    }

    // Customer elemeket módosító metódus
    private static void modifyCustomers(Document doc) {
        NodeList customerList = doc.getElementsByTagName("Customer");
        for (int i = 0; i < customerList.getLength(); i++) {
            Node customer = customerList.item(i);
            Element eElement = (Element) customer;
            int age = Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent());
            eElement.getElementsByTagName("age").item(0).setTextContent(String.valueOf(age + 5));
        }
    }
}