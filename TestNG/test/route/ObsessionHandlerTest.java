package tat.bsu.route;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * test class ObssesionHandler
 */
public class ObsessionHandlerTest {

    ObsessionHandler handler = new ObsessionHandler();

    @Test
    public void checkTwoCheckpointsWithEqualCoordinates() throws Exception {
        Checkpoint begin = new Checkpoint(1.0, 1.0);
        Checkpoint end = new Checkpoint(1.0, 1.0);
        boolean similar = handler.checkPathObsession(begin, end);
        assertTrue(similar);

    }
    @Test
    public void checkTwoCheckpointsWithDifferentCoordinates() throws Exception {
        Checkpoint begin = new Checkpoint(1.0, 1.0);
        Checkpoint end = new Checkpoint(1.0, 2.0);
        boolean different = handler.checkPathObsession(begin, end);
        assertFalse(different);

    }
    @Test
    public void checkPathThatHasOneCheckpoint() throws Exception {
        Checkpoint beginAndEnd = new Checkpoint(1.0, 1.0);
        boolean similar = handler.checkPathObsession(beginAndEnd, beginAndEnd);
        assertTrue(similar);
    }



}