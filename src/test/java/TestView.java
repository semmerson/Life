import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Copyright 2013 University Corporation for Atmospheric Research.  All rights
 * reserved.  See file LICENSE in the top-level source-directory for licensing
 * information.
 */

/**
 * @author Steven R. Emmerson
 */
public class TestView {
    /**
     * Test method for {@link View#display(Heartbeat)}.
     */
    @Test
    public final void testDisplay() {
        final View view = new View(2, 1);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        view.display(new Heartbeat() {
            @Override
            public boolean isAlive(final int outer, final int inner) {
                return inner == 0 && outer == 1;
            }
        });
        System.out.close();
        assertEquals("", "-\n \n#\n-\n", baos.toString());
    }
}
