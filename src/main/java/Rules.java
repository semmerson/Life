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
    /**
     * Returns the state of a point in the next iteration.
     * 
     * @param isAlive
     *            Whether or not the point is currently alive.
     * @param numNeighbors
     *            The number of live neighbors of the point.
     * @return <code>true</code> if and only if the point should be alive in the
     *         next iteration.
     */
    boolean nextState(final boolean isAlive, final int numNeighbors) {
        if (numNeighbors == 2) {
            return isAlive;
        }
        if (numNeighbors == 3) {
            return true;
        }
        return false;
    }
}
