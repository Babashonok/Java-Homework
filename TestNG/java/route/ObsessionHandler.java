package tat.bsu.route;

/**
 * Control obsession of the path
 */
public class ObsessionHandler {

    /**
     * check equality of begin and end
     * check initialization of the checkpoint
     * @param begin
     * @param end
     * @return
     */
    public boolean checkPathObsession(Checkpoint begin, Checkpoint end) {
        NullPointerHandler handler =new NullPointerHandler();
        handler.checkNullPointer(begin);
        handler.checkNullPointer(end);
        return (begin.getCoordX().compareTo(end.getCoordX()) == 0 && begin.getCoordY().compareTo(end.getCoordY()) == 0);
    }

}
