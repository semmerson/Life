import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

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
