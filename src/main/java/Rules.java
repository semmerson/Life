/**
 * 
 */


/**
 * @author emmerson
 */
final class Rules {
	State nextState(State state, int numNeighbors) {
        if (numNeighbors == 2)
        	return state;
        if (numNeighbors == 3)
        	return State.ALIVE;
        return State.DEAD;
	}
}
