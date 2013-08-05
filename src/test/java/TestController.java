import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

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
