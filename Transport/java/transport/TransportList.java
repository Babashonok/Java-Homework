package tat.bsu.transport;

import tat.bsu.route.DistanceCounter;

import java.util.ArrayList;

/**
 * Create list of objects that has common interface Moveable
 * Output information about every Object of the list
 */
public class TransportList {
    private ArrayList<Moveable> transportList = new ArrayList<Moveable>();

    /**
     * add to list object that implements interface Moveable
     * @param transport
     * @return
     */
    public TransportList add(Moveable transport) {
        transportList.add(transport);
        return this;
    }

    /**
     * output stats of every transport about passing the path
     * @param counter
     */
    public void outputStat(DistanceCounter counter) {
        for (Moveable temp : transportList) {
            System.out.println(temp.getInfoAboutMoves(counter));
        }
    }




}
