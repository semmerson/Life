import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author emmerson
 */
public class TestRules {
    static Rules rules = new Rules();

	@Test
	public void testNextState() {
        for (int n = 0; n < 2; n++) {
            assertEquals(State.DEAD, rules.nextState(State.DEAD, n));
            assertEquals(State.DEAD, rules.nextState(State.ALIVE, n));
        }
        for (int n = 8; n > 3; n--) {
            assertEquals(State.DEAD, rules.nextState(State.DEAD, n));
            assertEquals(State.DEAD, rules.nextState(State.ALIVE, n));
        }
        assertEquals(State.DEAD, rules.nextState(State.DEAD, 2));
        assertEquals(State.ALIVE, rules.nextState(State.ALIVE, 2));
        assertEquals(State.ALIVE, rules.nextState(State.DEAD, 3));
        assertEquals(State.ALIVE, rules.nextState(State.ALIVE, 3));
	}
}