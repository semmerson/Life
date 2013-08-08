/**
 * Copyright 2013 University Corporation for Atmospheric Research.  All rights
 * reserved.  See file LICENSE in the top-level source-directory for licensing
 * information.
 */
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Unit-test of the controller with mocked-up model and view.
 * 
 * @author Steven R. Emmerson
 */
public class TestController {
    @Test
    public final void testExecute() {
        final Model model = mock(Model.class);
        when(model.getHeartbeat()).thenReturn(null);
        final View view = mock(View.class);
        final Controller controller = new Controller(model, view);

        controller.execute(1);
        verify(view, times(2)).display(null);
        verify(model).advance();
    }
}
