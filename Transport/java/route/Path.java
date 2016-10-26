package tat.bsu.route;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represent whole path as ArrayList of Stations
 * find length of this path
 */
public class Path {

    private ArrayList<Checkpoint> path = new ArrayList<Checkpoint>();

    /**
     * create path as a list of checkpoints
     * @param output
     */
    public void createPath(Scanner output) {

        while (output.hasNext()) {
            path.add(new Checkpoint(output));
        }
    }
    /**
     * @return amount of Checkpoints
     */
    public  int getAmountOfCheckpoints() {
        return path.size();
    }
    /**
     * @param hash
     * @return certain Checkpoint
     */
    public Checkpoint getCertainCheckpoint(int hash) {
        return path.get(hash);
    }
}
