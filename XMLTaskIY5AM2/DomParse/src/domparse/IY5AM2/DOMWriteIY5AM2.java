package domparse.IY5AM2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class DOMWriteIY5AM2 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Gyökér elem létrehozása
            Element rootElement = doc.createElement("Car_IY5AM2");
            doc.appendChild(rootElement);

            // Namespace attribútumok hozzáadása
            rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "IY5AM2XSD.xsd");

            // Transaction elemek hozzáadása
            addTransaction(doc, rootElement, "1", "Tesómnak", "2023-11-14", "Cash");
            addTransaction(doc, rootElement, "2", "Üzleti", "2023-11-15", "Bank Transfer");
            addTransaction(doc, rootElement, "3", "Születésnapi Ajándék", "2023-11-16", "Credit Card");

            // Cars elemek hozzáadása
            addCar(doc, rootElement, "1", "1", "1", "Opel", "200.0", "69", "Available");
            addCar(doc, rootElement, "3", "2", "3", "Toyota", "150.0", "33", "Unavailable");
            addCar(doc, rootElement, "4", "3", "2", "BMW", "300.0", "44", "Available");

            // Driver elemek hozzáadása
            addDriver(doc, rootElement, "1", "06501311010", "Male", "3534", "Miskolc", "Árpád", "Buha", "Milán");
            addDriver(doc, rootElement, "2", "06502223344", "Male", "1122", "Debrecen", "Kossuth", "Szabó", "László");
            addDriver(doc, rootElement, "3", "06505556677", "Female", "2045", "Törökbálint", "Fő", "Nagy", "Anna");

            // Customer elemek hozzáadása
            addCustomer(doc, rootElement, "1", "1", "Female", "20", "barbara@gmail.com", "3535", "Miskolc", "Kuruc", "Valaki", "Barbara");
            addCustomer(doc, rootElement, "2", "2", "Male", "30", "istvan@gmail.com", "6000", "Kecskemét", "Petőfi", "István", "Szabó");
            addCustomer(doc, rootElement, "3", "3", "Female", "25", "eszter@gmail.com", "6722", "Szeged", "József", "Eszter", "Kovács");

            // Admin elemek hozzáadása
            addAdmin(doc, rootElement, "1", "Male", "32", "admin@gmail.com", "3634", "Valahol", "Napfény", "Kiss", "János");
            addAdmin(doc, rootElement, "2", "Female", "28", "admin2@gmail.com", "7632", "Pécs", "Hunyadi", "Tóth", "Krisztina");
            addAdmin(doc, rootElement, "3", "Male", "40", "admin3@gmail.com", "1012", "Budapest", "Vár", "Varga", "Mihály");

            // Approving elemek hozzáadása
            addApproving(doc, rootElement, "1", "1", "1", "2023-11-14");
            addApproving(doc, rootElement, "2", "2", "2", "2023-11-15");
            addApproving(doc, rootElement, "3", "3", "3", "2023-11-16");

            // XML fájl írása
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            // XML output file megadása
            StreamResult fileResult = new StreamResult(new File("C:\\Users\\Sziszi\\Desktop\\IY5AM2_XMLGyak\\XMLTaskIY5AM2\\IY5AM2XML_WRITE.xml"));
            transformer.transform(source, fileResult);

            System.out.println("The content has been written to the output file successfully.");
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Valami baj van: " + e);
        }
    }

    // Segédfüggvény az elemek hozzáadásához
    private static void addTransaction(Document doc, Element root, String id, String name, String date, String data) {
        Element transaction = doc.createElement("Transaction");
        transaction.setAttribute("transaction_id", id);
        root.appendChild(transaction);

        Element transactionName = doc.createElement("transaction_name");
        transactionName.appendChild(doc.createTextNode(name));
        transaction.appendChild(transactionName);

        Element transactionDate = doc.createElement("transaction_date");
        transactionDate.appendChild(doc.createTextNode(date));
        transaction.appendChild(transactionDate);

        Element transactions = doc.createElement("transactions");
        transaction.appendChild(transactions);

        Element transactionData = doc.createElement("transaction_data");
        transactionData.appendChild(doc.createTextNode(data));
        transactions.appendChild(transactionData);
    }

    // Segédfüggvény az elemek hozzáadásához
    private static void addCar(Document doc, Element root, String carId, String transaction, String driver, String model, String price, String number, String status) {
        Element car = doc.createElement("Cars");
        car.setAttribute("car_id", carId);
        car.setAttribute("transaction", transaction);
        car.setAttribute("driver", driver);
        root.appendChild(car);

        Element carModel = doc.createElement("car_modell");
        carModel.appendChild(doc.createTextNode(model));
        car.appendChild(carModel);

        Element rentPrice = doc.createElement("rent_price");
        rentPrice.appendChild(doc.createTextNode(price));
        car.appendChild(rentPrice);

        Element carNumber = doc.createElement("car_number");
        carNumber.appendChild(doc.createTextNode(number));
        car.appendChild(carNumber);

        Element carStatus = doc.createElement("car_status");
        carStatus.appendChild(doc.createTextNode(status));
        car.appendChild(carStatus);
    }

    // Segédfüggvény az elemek hozzáadásához
    private static void addDriver(Document doc, Element root, String driverId, String phoneNumber, String gender, String postCode, String city, String street, String firstName, String lastName) {
        Element driver = doc.createElement("Driver");
        driver.setAttribute("driver_id", driverId);
        root.appendChild(driver);

        Element phoneElement = doc.createElement("phone_number");
        phoneElement.appendChild(doc.createTextNode(phoneNumber));
        driver.appendChild(phoneElement);

        Element genderElement = doc.createElement("gender");
        genderElement.appendChild(doc.createTextNode(gender));
        driver.appendChild(genderElement);

        Element postCodeElement = doc.createElement("post_code");
        postCodeElement.appendChild(doc.createTextNode(postCode));
        driver.appendChild(postCodeElement);

        Element cityElement = doc.createElement("city");
        cityElement.appendChild(doc.createTextNode(city));
        driver.appendChild(cityElement);

        Element streetElement = doc.createElement("street");
        streetElement.appendChild(doc.createTextNode(street));
        driver.appendChild(streetElement);

        Element firstNameElement = doc.createElement("first_name");
        firstNameElement.appendChild(doc.createTextNode(firstName));
        driver.appendChild(firstNameElement);

        Element lastNameElement = doc.createElement("last_name");
        lastNameElement.appendChild(doc.createTextNode(lastName));
        driver.appendChild(lastNameElement);
    }

    // Segédfüggvény az elemek hozzáadásához
    private static void addCustomer(Document doc, Element root, String customerId, String transaction, String gender, String age, String email, String postCode, String city, String street, String firstName, String lastName) {
        Element customer = doc.createElement("Customer");
        customer.setAttribute("customer_id", customerId);
        customer.setAttribute("transaction", transaction);
        root.appendChild(customer);

        Element genderElement = doc.createElement("gender");
        genderElement.appendChild(doc.createTextNode(gender));
        customer.appendChild(genderElement);

        Element ageElement = doc.createElement("age");
        ageElement.appendChild(doc.createTextNode(age));
        customer.appendChild(ageElement);

        Element emailElement = doc.createElement("cust_email");
        emailElement.appendChild(doc.createTextNode(email));
        customer.appendChild(emailElement);

        Element postCodeElement = doc.createElement("post_code");
        postCodeElement.appendChild(doc.createTextNode(postCode));
        customer.appendChild(postCodeElement);

        Element cityElement = doc.createElement("city");
        cityElement.appendChild(doc.createTextNode(city));
        customer.appendChild(cityElement);

        Element streetElement = doc.createElement("street");
        streetElement.appendChild(doc.createTextNode(street));
        customer.appendChild(streetElement);

        Element firstNameElement = doc.createElement("first_name");
        firstNameElement.appendChild(doc.createTextNode(firstName));
        customer.appendChild(firstNameElement);

        Element lastNameElement = doc.createElement("last_name");
        lastNameElement.appendChild(doc.createTextNode(lastName));
        customer.appendChild(lastNameElement);
    }

    // Segédfüggvény az elemek hozzáadásához
    private static void addAdmin(Document doc, Element root, String adminId, String gender, String age, String email, String postCode, String city, String street, String firstName, String lastName) {
        Element admin = doc.createElement("Admin");
        admin.setAttribute("admin_id", adminId);
        root.appendChild(admin);

        Element genderElement = doc.createElement("gender");
        genderElement.appendChild(doc.createTextNode(gender));
        admin.appendChild(genderElement);

        Element ageElement = doc.createElement("age");
        ageElement.appendChild(doc.createTextNode(age));
        admin.appendChild(ageElement);

        Element emailElement = doc.createElement("admin_email");
        emailElement.appendChild(doc.createTextNode(email));
        admin.appendChild(emailElement);

        Element postCodeElement = doc.createElement("post_code");
        postCodeElement.appendChild(doc.createTextNode(postCode));
        admin.appendChild(postCodeElement);

        Element cityElement = doc.createElement("city");
        cityElement.appendChild(doc.createTextNode(city));
        admin.appendChild(cityElement);

        Element streetElement = doc.createElement("street");
        streetElement.appendChild(doc.createTextNode(street));
        admin.appendChild(streetElement);

        Element firstNameElement = doc.createElement("first_name");
        firstNameElement.appendChild(doc.createTextNode(firstName));
        admin.appendChild(firstNameElement);

        Element lastNameElement = doc.createElement("last_name");
        lastNameElement.appendChild(doc.createTextNode(lastName));
        admin.appendChild(lastNameElement);
    }

    // Segédfüggvény az elemek hozzáadásához
    private static void addApproving(Document doc, Element root, String approvingId, String adminId, String transactionId, String date) {
        Element approving = doc.createElement("Approving");
        approving.setAttribute("approving_id", approvingId);
        approving.setAttribute("admin", adminId);
        approving.setAttribute("transaction", transactionId);
        root.appendChild(approving);

        Element dateElement = doc.createElement("verification_date");
        dateElement.appendChild(doc.createTextNode(date));
        approving.appendChild(dateElement);
    }
}