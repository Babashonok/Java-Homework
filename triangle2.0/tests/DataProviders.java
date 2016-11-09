package triangle;

import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;


/**
 * DataProviders
 */
public class DataProviders {

    private static final String SIDE_A = "side_a";
    private static final String SIDE_B = "side_b";
    private static final String SIDE_C = "side_c";
    private static final String MESSAGE = "typeMessage";
    private static final String STRING = "string";

    private static final String TRIANGLE = "triangle";
    private static final String NONEXIST = "nonExist";
    private static final String INVALID = "invalid";

    private static final String filePath = "data.xml";

    /**
     * removal of duplicate code from data providers
     * @return
     * @throws Exception
     */
    public static Document getDocument() throws Exception {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(file);
    }

    @DataProvider (name = "valid triangles")
    public static Object[][] getEquilateralTriangles() throws Throwable {
        Document document = getDocument();
        NodeList nodes = document.getElementsByTagName(TRIANGLE);
        Object[][] triangles = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            triangles[i] = new Object[] {
                       new Triangle(new BigDecimal[] {
                                    new BigDecimal(attrs.getNamedItem(SIDE_A).getNodeValue()),
                                    new BigDecimal(attrs.getNamedItem(SIDE_B).getNodeValue()),
                                    new BigDecimal(attrs.getNamedItem(SIDE_C).getNodeValue())}),
                    attrs.getNamedItem(MESSAGE).getNodeValue()
            };
        }
    return triangles;
    }
    @DataProvider (name = "nonExist triangles")
    public static Object[][] getNonExistTriangles() throws Exception {
        Document document = getDocument();
        NodeList nodes = document.getElementsByTagName(NONEXIST);
        Object[][] triangles = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            triangles[i] = new Object[] {
                    new BigDecimal(attrs.getNamedItem(SIDE_A).getNodeValue()),
                    new BigDecimal(attrs.getNamedItem(SIDE_B).getNodeValue()),
                    new BigDecimal(attrs.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return triangles;
    }
    @DataProvider(name = "InvalidInput")
    public static Object[][] getInvalidInputVariables() throws Exception {
        Document document = getDocument();
        NodeList nodes = document.getElementsByTagName(INVALID);
        Object[][] triangles = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            triangles[i] = new Object[] {
                    attrs.getNamedItem(STRING) == null ? null : new BigDecimal(attrs.getNamedItem(STRING).getNodeValue())
            };
        }
        return triangles;
    }
}
