/**
 * Copyright 2013 University Corporation for Atmospheric Research.  All rights
 * reserved.  See file LICENSE in the top-level source-directory for licensing
 * information.
 */

import net.jcip.annotations.NotThreadSafe;

/**
 * The "Game of Life" model.
 * <p>
 * Instances are thread-compatible but not thread safe.
 * 
 * @author Steven R. Emmerson
 */
@NotThreadSafe
class Model {
    /**
     * The grids.
     */
    private final boolean[][][] grids;
    /**
     * Index of the current grid.
     */
    private final int           curr = 0;

    /**
     * Constructs from the sizes of the inner and outer dimensions. All points
     * are initially dead.
     * 
     * @param outerSize
     *            The size of the outer dimension.
     * @param innerSize
     *            The size of the inner dimension.
     * @throws IllegalArgumentException
     *             if innerSize < 0 || outerSize < 0
     */
    Model(final int outerSize, final int innerSize) {
        if (innerSize < 0 || outerSize < 0) {
            throw new IllegalArgumentException("innerSize=" + innerSize
                    + "; outerSize=" + outerSize);
        }
        grids = new boolean[2][outerSize][innerSize];
    }

    /**
     * Ensures that a point is alive.
     * 
     * @param outer
     *            The outer dimension index of the point.
     * @param inner
     *            The inner dimension index of the point.
     * @throws ArrayIndexOutOfBoundsException
     *             if the point doesn't exist.
     */
    void setAlive(final int outer, final int inner) {
        grids[curr][outer][inner] = true;
    }

    /**
     * Returns a heartbeat object that indicates what points are alive.
     * 
     * @return an object that identifies the live points.
     * @throws ArrayIndexOutOfBoundsException
     *             if the point doesn't exist.
     */
    Heartbeat getHeartbeat() {
        return new Heartbeat() {
            @Override
            public boolean isAlive(final int outer, final int inner) {
                return grids[curr][outer][inner];
            }
        };
    }

    /**
     * Advances the model one time-step.
     */
    void advance() {
    }
}
