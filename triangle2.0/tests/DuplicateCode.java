package triangle;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Entity to work with code duplication in data providers
 */
public class DuplicateCode {

    private static final String filePath = "data.xml";
    private NodeList nodes;

    /**
     * read data from XML file
     * create list of nodes with equal tag name
     * @param message tag name
     * @throws Exception
     */
    public DuplicateCode(String message) throws Exception {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        nodes = document.getElementsByTagName(message);
    }
    /**
     * return empty mathix of objects
     * number of string = number of elements with equal tag name in XML file
     * @return
     */
    public Object [][] getMatrixOfObjects() {
        return new Object[nodes.getLength()][];
    }
    /**
     * return list of nodes with equal tag name
     * @return
     */
    public NodeList getListOfNodes() {
        return nodes;
    }
}
