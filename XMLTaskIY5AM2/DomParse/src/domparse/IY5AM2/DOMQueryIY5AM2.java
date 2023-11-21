package domparse.IY5AM2;

import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DOMQueryIY5AM2 {

    public static void main(String[] argv) throws SAXException, IOException, ParserConfigurationException {
        File xmlFile = new File("M:\\Egyetem\\IY5AM2_XMLGyak\\XMLTaskIY5AM2\\IY5AM2XML.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        StringBuilder outputBuilder = new StringBuilder();

        // Lekérdezés a 'Toyota' modellel rendelkező autókra
        NodeList carsList = doc.getElementsByTagName("Cars");
        outputBuilder.append("\n<ToyotaCars>\n");
        for (int i = 0; i < carsList.getLength(); i++) {
            Node node = carsList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String model = element.getElementsByTagName("car_modell").item(0).getTextContent();
                if (model.equals("Toyota")) {
                    String carId = element.getAttribute("car_id");
                    String rentPrice = element.getElementsByTagName("rent_price").item(0).getTextContent();
                    outputBuilder.append(String.format("  <Car car_id=\"%s\">\n", carId));
                    outputBuilder.append(String.format("    <Model>%s</Model>\n", model));
                    outputBuilder.append(String.format("    <RentPrice>%s</RentPrice>\n", rentPrice));
                    outputBuilder.append("  </Car>\n");
                }
            }
        }
        outputBuilder.append("</ToyotaCars>\n");

        // Lekérdezés a 'Male' nemű sofőrökre
        NodeList driverList = doc.getElementsByTagName("Driver");
        outputBuilder.append("\n<MaleDrivers>\n");
        for (int i = 0; i < driverList.getLength(); i++) {
            Node node = driverList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                if (gender.equals("Male")) {
                    String driverId = element.getAttribute("driver_id");
                    String firstName = element.getElementsByTagName("first_name").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("last_name").item(0).getTextContent();
                    outputBuilder.append(String.format("  <Driver driver_id=\"%s\">\n", driverId));
                    outputBuilder.append(String.format("    <FirstName>%s</FirstName>\n", firstName));
                    outputBuilder.append(String.format("    <LastName>%s</LastName>\n", lastName));
                    outputBuilder.append(String.format("    <Gender>%s</Gender>\n", gender));
                    outputBuilder.append("  </Driver>\n");
                }
            }
        }
        outputBuilder.append("</MaleDrivers>\n");


        // Lekérdezés a 25 évnél fiatalabb ügyfelekre
        NodeList customerList = doc.getElementsByTagName("Customer");
        outputBuilder.append("\n<YoungCustomers>\n");
        for (int i = 0; i < customerList.getLength(); i++) {
            Node node = customerList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
                if (age < 25) {
                    String customerId = element.getAttribute("customer_id");
                    String firstName = element.getElementsByTagName("first_name").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("last_name").item(0).getTextContent();
                    outputBuilder.append(String.format("  <Customer customer_id=\"%s\">\n", customerId));
                    outputBuilder.append(String.format("    <FirstName>%s</FirstName>\n", firstName));
                    outputBuilder.append(String.format("    <LastName>%s</LastName>\n", lastName));
                    outputBuilder.append(String.format("    <Age>%d</Age>\n", age));
                    outputBuilder.append("  </Customer>\n");
                }
            }
        }
        outputBuilder.append("</YoungCustomers>\n");

// Lekérdezés az adminisztrátorokra Budapest városából
        NodeList adminList = doc.getElementsByTagName("Admin");
        outputBuilder.append("\n<BudapestAdmins>\n");
        for (int i = 0; i < adminList.getLength(); i++) {
            Node node = adminList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String city = element.getElementsByTagName("city").item(0).getTextContent();
                if (city.equals("Budapest")) {
                    String adminId = element.getAttribute("admin_id");
                    String firstName = element.getElementsByTagName("first_name").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("last_name").item(0).getTextContent();
                    outputBuilder.append(String.format("  <Admin admin_id=\"%s\">\n", adminId));
                    outputBuilder.append(String.format("    <FirstName>%s</FirstName>\n", firstName));
                    outputBuilder.append(String.format("    <LastName>%s</LastName>\n", lastName));
                    outputBuilder.append(String.format("    <City>%s</City>\n", city));
                    outputBuilder.append("  </Admin>\n");
                }
            }
        }
        outputBuilder.append("</BudapestAdmins>\n");

        System.out.println(outputBuilder);
    }
}