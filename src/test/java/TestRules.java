import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit-test for the "Game of Life" rules.
 * 
 * @author Steven R. Emmerson
 */
public class TestRules {
    @Test
    public void testNextState() {
        final Rules rules = new Rules();
        for (int n = 0; n < 2; n++) {
            assertEquals(false, rules.nextState(false, n));
            assertEquals(false, rules.nextState(true, n));
        }
        for (int n = 8; n > 3; n--) {
            assertEquals(false, rules.nextState(false, n));
            assertEquals(false, rules.nextState(true, n));
        }
        assertEquals(false, rules.nextState(false, 2));
        assertEquals(true, rules.nextState(true, 2));
        assertEquals(true, rules.nextState(false, 3));
        assertEquals(true, rules.nextState(true, 3));
    }
}