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
     * check operable range of coordinates, if no, throw IllegalArgumentException
     * @param coordX
     * @param coordY
     */
    public Checkpoint(double coordX, double coordY)  throws IllegalArgumentException {
        if (Math.abs(coordX) > (Math.sqrt(Double.MAX_VALUE)) || Math.abs(coordY) > Math.sqrt(Double.MAX_VALUE)) {
            throw new IllegalArgumentException();
        }
        setCoordX(coordX);
        setCoordY(coordY);
    }
    /**
     * set X coordinate
     */
    private void setCoordX(double coordX) {
        this.coordX = coordX;
    }
    /**
     * set Y coordinate
     * @param coordY
     */
    private void setCoordY(double coordY) {
        this.coordY = coordY;
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
