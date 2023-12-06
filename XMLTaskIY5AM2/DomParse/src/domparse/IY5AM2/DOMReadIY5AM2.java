package domparse.IY5AM2;

import javax.xml.parsers.*;

import org.xml.sax.SAXException;
import org.w3c.dom.*;

import java.io.*;

public class DOMReadIY5AM2 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Sziszi\\Desktop\\IY5AM2_XMLGyak\\XMLTaskIY5AM2\\IY5AM2XML.xml"));

            document.getDocumentElement().normalize();
            System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            System.out.println("<Car_IY5AM2 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"IY5AM2XSD.xsd\">\n");

            // Elemeket beolvasó metódusok
            readTransactions(document);
            readCars(document);
            readDrivers(document);
            readCustomers(document);
            readAdmins(document);
            readApprovings(document);

            System.out.println("\n</Car_IY5AM2>");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println("Valami baj van: " + e);
        }
    }

    // Transaction Node beolvasó metódus
    private static void readTransactions(Document document) {
        NodeList transactionList = document.getElementsByTagName("Transaction");
        for (int temp = 0; temp < transactionList.getLength(); temp++) {
            Node node = transactionList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String transactionId = eElement.getAttribute("transaction_id");
                String transactionName = eElement.getElementsByTagName("transaction_name").item(0).getTextContent();
                String transactionDate = eElement.getElementsByTagName("transaction_date").item(0).getTextContent();

                System.out.println("    <Transaction transaction_id=\"" + transactionId + "\">");
                printElement("transaction_name", transactionName);
                printElement("transaction_date", transactionDate);

                // Transaction Data elemek kiolvasása
                NodeList transactionDataList = eElement.getElementsByTagName("transaction_data");
                for (int i = 0; i < transactionDataList.getLength(); i++) {
                    String transactionData = transactionDataList.item(i).getTextContent();
                    printElement("transaction_data", transactionData);
                }

                System.out.println("    </Transaction>");
            }
        }
    }

    // Cars Node beolvasó metódus
    private static void readCars(Document document) {
        NodeList carsList = document.getElementsByTagName("Cars");
        for (int temp = 0; temp < carsList.getLength(); temp++) {
            Node node = carsList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String carId = eElement.getAttribute("car_id");
                String carModel = eElement.getElementsByTagName("car_modell").item(0).getTextContent();
                String rentPrice = eElement.getElementsByTagName("rent_price").item(0).getTextContent();
                String carNumber = eElement.getElementsByTagName("car_number").item(0).getTextContent();
                String carStatus = eElement.getElementsByTagName("car_status").item(0).getTextContent();

                System.out.println("    <Cars car_id=\"" + carId + "\">");
                printElement("car_modell", carModel);
                printElement("rent_price", rentPrice);
                printElement("car_number", carNumber);
                printElement("car_status", carStatus);
                System.out.println("    </Cars>");
            }
        }
    }

    // Driver Node beolvasó metódus
    private static void readDrivers(Document document) {
        NodeList driverList = document.getElementsByTagName("Driver");
        for (int temp = 0; temp < driverList.getLength(); temp++) {
            Node node = driverList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String driverId = eElement.getAttribute("driver_id");
                String phoneNumber = eElement.getElementsByTagName("phone_number").item(0).getTextContent();
                String gender = eElement.getElementsByTagName("gender").item(0).getTextContent();
                String postCode = eElement.getElementsByTagName("post_code").item(0).getTextContent();
                String city = eElement.getElementsByTagName("city").item(0).getTextContent();
                String street = eElement.getElementsByTagName("street").item(0).getTextContent();
                String firstName = eElement.getElementsByTagName("first_name").item(0).getTextContent();
                String lastName = eElement.getElementsByTagName("last_name").item(0).getTextContent();

                System.out.println("    <Driver driver_id=\"" + driverId + "\">");
                printElement("phone_number", phoneNumber);
                printElement("gender", gender);
                printElement("post_code", postCode);
                printElement("city", city);
                printElement("street", street);
                printElement("first_name", firstName);
                printElement("last_name", lastName);
                System.out.println("    </Driver>");
            }
        }
    }

    // Customer Node beolvasó metódus
    private static void readCustomers(Document document) {
        NodeList customerList = document.getElementsByTagName("Customer");
        for (int temp = 0; temp < customerList.getLength(); temp++) {
            Node node = customerList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String customerId = eElement.getAttribute("customer_id");
                String gender = eElement.getElementsByTagName("gender").item(0).getTextContent();
                String age = eElement.getElementsByTagName("age").item(0).getTextContent();
                String email = eElement.getElementsByTagName("cust_email").item(0).getTextContent();
                String postCode = eElement.getElementsByTagName("post_code").item(0).getTextContent();
                String city = eElement.getElementsByTagName("city").item(0).getTextContent();
                String street = eElement.getElementsByTagName("street").item(0).getTextContent();
                String firstName = eElement.getElementsByTagName("first_name").item(0).getTextContent();
                String lastName = eElement.getElementsByTagName("last_name").item(0).getTextContent();

                System.out.println("    <Customer customer_id=\"" + customerId + "\">");
                printElement("gender", gender);
                printElement("age", age);
                printElement("cust_email", email);
                printElement("post_code", postCode);
                printElement("city", city);
                printElement("street", street);
                printElement("first_name", firstName);
                printElement("last_name", lastName);
                System.out.println("    </Customer>");
            }
        }
    }

    // Admin Node beolvasó metódus
    private static void readAdmins(Document document) {
        NodeList adminList = document.getElementsByTagName("Admin");
        for (int temp = 0; temp < adminList.getLength(); temp++) {
            Node node = adminList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String adminId = eElement.getAttribute("admin_id");
                String gender = eElement.getElementsByTagName("gender").item(0).getTextContent();
                String age = eElement.getElementsByTagName("age").item(0).getTextContent();
                String email = eElement.getElementsByTagName("admin_email").item(0).getTextContent();
                String postCode = eElement.getElementsByTagName("post_code").item(0).getTextContent();
                String city = eElement.getElementsByTagName("city").item(0).getTextContent();
                String street = eElement.getElementsByTagName("street").item(0).getTextContent();
                String firstName = eElement.getElementsByTagName("first_name").item(0).getTextContent();
                String lastName = eElement.getElementsByTagName("last_name").item(0).getTextContent();

                System.out.println("    <Admin admin_id=\"" + adminId + "\">");
                printElement("gender", gender);
                printElement("age", age);
                printElement("admin_email", email);
                printElement("post_code", postCode);
                printElement("city", city);
                printElement("street", street);
                printElement("first_name", firstName);
                printElement("last_name", lastName);
                System.out.println("    </Admin>");
            }
        }
    }

    // Approving Node beolvasó metódus
    private static void readApprovings(Document document) {
        NodeList approvingList = document.getElementsByTagName("Approving");
        for (int temp = 0; temp < approvingList.getLength(); temp++) {
            Node node = approvingList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String approvingId = eElement.getAttribute("approving_id");
                String admin = eElement.getAttribute("admin");
                String transaction = eElement.getAttribute("transaction");
                String verificationDate = eElement.getElementsByTagName("verification_date").item(0).getTextContent();

                System.out.println("    <Approving approving_id=\"" + approvingId + "\" admin=\"" + admin + "\" transaction=\"" + transaction + "\">");
                printElement("verification_date", verificationDate);
                System.out.println("    </Approving>");
            }
        }
    }

    // Elem kiírató metódus
    private static void printElement(String elementName, String content) {
        System.out.println("        <" + elementName + ">" + content + "</" + elementName + ">");
    }
}