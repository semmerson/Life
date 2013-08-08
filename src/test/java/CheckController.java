/**
 * Copyright 2013 University Corporation for Atmospheric Research.  All rights
 * reserved.  See file LICENSE in the top-level source-directory for licensing
 * information.
 */
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Integration-test of the controller, model, and view.
 * 
 * @author Steven R. Emmerson
 */
public class CheckController {
    /**
     * Test method for {@link Controller#execute(int)}.
     */
    @Test
    public final void testExecute() {
        final Model model = new Model(5, 5);
        final View view = new View(5, 5);
        final Controller controller = new Controller(model, view);

        model.setAlive(2, 1);
        model.setAlive(2, 2);
        model.setAlive(2, 3);

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        controller.execute(1);
        System.out.close();
        assertEquals("", "     \n     \n ### \n     \n     \n"
                + "     \n  #  \n  #  \n  #  \n     \n", baos.toString());
    }
}
