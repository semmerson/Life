/**
 * Copyright 2013 University Corporation for Atmospheric Research. All rights
 * reserved. See file LICENSE in the top-level source-directory for licensing
 * information.
 */

/**
 * The "Game of Life" rules.
 * 
 * @author Steven R. Emmerson
 */
final class Rules {
    State nextState(final State state, final int numNeighbors) {
        if (numNeighbors == 2) {
            return state;
        }
        if (numNeighbors == 3) {
            return State.ALIVE;
        }
        return State.DEAD;
    }
}
