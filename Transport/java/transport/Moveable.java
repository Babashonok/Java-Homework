package tat.bsu.transport;

import tat.bsu.route.DistanceCounter;

/**
 * Interface that unites all Objects of this program
 * that can move
 */
public interface Moveable {
    /**
     * gives object an ability to determine oneself speed
     * @return
     */
    double getSpeed();

    /**
     * gives object an ability to output characteristics about movement
     * @param counter
     * @return
     */
    String getInfoAboutMoves(DistanceCounter counter);
}
