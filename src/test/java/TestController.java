import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TestController {
    @Test
    public final void testExecute() {
        final Model model = mock(Model.class);
        final View view = mock(View.class);
        final Controller controller = new Controller(model, view);
        final int points[][] = new int[][] { { 1, 2 } };

        when(model.getPoints()).thenReturn(points);
        controller.execute(1);
        verify(model).advance();
        verify(view).display(points);
    }
}
