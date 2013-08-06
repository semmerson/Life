import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Copyright 2013 University Corporation for Atmospheric Research.  All rights
 * reserved.  See file LICENSE in the top-level source-directory for licensing
 * information.
 */

/**
 * Unit-test for the model.
 * 
 * @author Steven R. Emmerson
 */
public class TestModel {
    /**
     * Test method for {@link Model#Model(int, int)}.
     */
    @Test
    public final void testModel() {
        final Model model = new Model(2, 3);
        assertNotNull(model);
    }

    /**
     * Test method for {@link Model#getHeartbeat()}.
     */
    @Test
    public final void testGetHeartbeat() {
        final Model model = new Model(2, 3);
        final Heartbeat heartbeat = model.getHeartbeat();
        assertNotNull(heartbeat);
    }

    /**
     * Test method for {@link Model#setAlive(int, int)}.
     */
    @Test
    public final void testSetAlive() {
        final Model model = new Model(2, 3);
        final Heartbeat heartbeat = model.getHeartbeat();
        assertFalse(heartbeat.isAlive(1, 2));
        model.setAlive(1, 2);
        assertTrue(heartbeat.isAlive(1, 2));
    }
}
