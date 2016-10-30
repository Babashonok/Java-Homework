package tat.bsu.route;

/**
 * Class used for couting distances
 * (between stations or whole path)
 */
public class DistanceCounter  {
    private double distance;

    /**
     * constructor that initialize field distance
     * as distance of whole path
     * @param path
     */
    public DistanceCounter(Path path) {
        this.distance = findWholeDistance(path);
    }

    /**
     * find distance of whole path as sum of distances between checkpoints
     * @param path
     * @return
     */
    public double findWholeDistance (Path path) {
        int tempDistance = 0 ;
        for (int i = 1; i<path.getAmountOfCheckpoints() ; i++ ) {
            tempDistance += findDistanceBetweenTwoCheckpoints(path.getCertainCheckpoint(i - 1), path.getCertainCheckpoint(i));
        }
        return  tempDistance;
    }

    /**
     * find distance between checkpoints
     * @param currentCheckpoint
     * @param nextCheckpoint
     * @return
     */
    public double findDistanceBetweenTwoCheckpoints(Checkpoint currentCheckpoint, Checkpoint nextCheckpoint) {
        return Math.sqrt((Math.pow(nextCheckpoint.getCoordX() - currentCheckpoint.getCoordX(), 2.0))
                + (Math.pow(nextCheckpoint.getCoordY() - currentCheckpoint.getCoordY(), 2.0)));

    }

    /**
     * @return whole distance
     */
    public double getWholeDistance() {
        return distance;
    }

}
