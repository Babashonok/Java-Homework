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
     * @throws NumberFormatException
     */
    public void createPath(Scanner output) throws NumberFormatException {
        while (output.hasNext()) {
            path.add(new Checkpoint(Double.parseDouble(output.next()), Double.parseDouble(output.next())));
        }
    }

    /**
     * gives possibility to add user-made checkpoint to the end of the path
     * @param checkpoint
     */
    public void addCheckpointToThePath(Checkpoint checkpoint) {
        path.add(checkpoint);
    }
    /**
     * @return amount of Checkpoints
     */
    public int getAmountOfCheckpoints() {
        return path.size();
    }
    /**
     * @param numberInListOfCheckpoints
     * @return certain Checkpoint
     */
    public Checkpoint getCertainCheckpoint(int numberInListOfCheckpoints) {
        return path.get(numberInListOfCheckpoints);
    }
}
