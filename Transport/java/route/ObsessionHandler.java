package tat.bsu.route;

/**
 * Control obsession of the path
 */
public class ObsessionHandler {

    /**
     * check equality of begin and end
     * @param begin
     * @param end
     * @return
     */
    public boolean checkPathObsession(Checkpoint begin, Checkpoint end) {
        return (begin.getCoordX().compareTo(end.getCoordX()) == 0 && begin.getCoordY().compareTo(end.getCoordY()) == 0);
    }

}
