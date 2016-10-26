package tat.bsu.route;

import java.util.Scanner;

/**
 * Class that represent one certain station
 */
public class Checkpoint {

    private Double coordX;
    private Double coordY;

    /**
     * costructor to create checkpoint as X and Y coordinates
     * @param output
     * @throws NumberFormatException
     */
    public Checkpoint(Scanner output) throws NumberFormatException {
        setCoordX(output);
        setCoordY(output);
    }

    /**
     * set X coordinate from file
     * @param output
     */
    private void setCoordX(Scanner output) {
        this.coordX =Double.parseDouble(output.next());
    }
    /**
     * set Y coordinate from file
     * @param output
     */
    private void setCoordY(Scanner output) {
        this.coordY =Double.parseDouble(output.next());
    }

    /**
     * @return  return X coordinate of this checkpoint
     */
    public Double getCoordX() {
        return coordX;
    }
    /**
     * @return  return Y coordinate of this checkpoint
     */
    public Double getCoordY() {
        return coordY;
    }


}
