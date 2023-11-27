package domparse.IY5AM2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class DOMWriteIY5AM2 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("C:\\Users\\buha3\\Desktop\\XMLTaskIY5AM2\\IY5AM2XML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // XML falj kiiratasa a konzolra
            System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
            writeDocumentToFile(doc);

            System.out.println("The content has been written to the output file successfully.");
        } catch (SAXException | IOException | ParserConfigurationException | TransformerException e) {
            System.out.println("Valami baj van: " + e);
        }
    }

    private static void writeDocumentToFile(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("C:\\Users\\buha3\\Desktop\\XMLTaskIY5AM2\\IY5AM2XML_WRITE.xml"));
        transformer.transform(source, result);
    }
}