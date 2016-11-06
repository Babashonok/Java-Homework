package tat.bsu.route;

/**
 * Class that check initialization of checkpoints
 */
public class NullPointerHandler {
    /**
     * throw NullPointerException if checkpoint is equal to null object
     * @param checkpoint
     * @throws NullPointerException
     */
    public void checkNullPointer(Checkpoint checkpoint) throws NullPointerException {
        if (checkpoint.equals(null)) {
            throw new NullPointerException();
        }
    }
}
