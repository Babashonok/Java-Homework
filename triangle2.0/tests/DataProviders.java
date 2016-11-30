package triangle;

import org.testng.annotations.DataProvider;
import org.w3c.dom.NamedNodeMap;
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


    @DataProvider (name = "valid triangles")
    public static Object[][] getEquilateralTriangles() throws Throwable {
        DuplicateCode code = new DuplicateCode(TRIANGLE);
        Object[][] triangles = code.getMatrixOfObjects();
        for (int i = 0; i <code.getListOfNodes().getLength(); i++) {
            NamedNodeMap attrs = code.getListOfNodes().item(i).getAttributes();
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
        DuplicateCode code = new DuplicateCode(NONEXIST);
        Object[][] triangles = code.getMatrixOfObjects();
        for (int i = 0; i < code.getListOfNodes().getLength(); i++) {
            NamedNodeMap attrs = code.getListOfNodes().item(i).getAttributes();
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
        DuplicateCode code = new DuplicateCode(INVALID);
        Object[][] triangles = code.getMatrixOfObjects();
        for (int i = 0 ; i < code.getListOfNodes().getLength() ; i++) {
            NamedNodeMap attrs = code.getListOfNodes().item(i).getAttributes();
            triangles[i] = new Object[] {
                    attrs.getNamedItem(STRING) == null ? null : new BigDecimal(attrs.getNamedItem(STRING).getNodeValue())
            };
        }
        return triangles;
    }
}
