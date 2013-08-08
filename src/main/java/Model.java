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
     * Size of the outer dimension.
     */
    private final int           outerSize;
    /**
     * Size of the innter dimension.
     */
    private final int           innerSize;
    /**
     * The grids.
     */
    private final boolean[][][] grids;
    /**
     * Index of the current grid.
     */
    private int                 curr  = 0;
    /**
     * The rules governing the game.
     */
    private final Rules         rules = new Rules();

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
        this.outerSize = outerSize;
        this.innerSize = innerSize;
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
     * Returns a heartbeat object that indicates which points are currently
     * alive.
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
        final int next = (curr == 0)
                ? 1
                : 0;
        for (int outer = 0; outer < outerSize; outer++) {
            for (int inner = 0; inner < innerSize; inner++) {
                grids[next][outer][inner] = rules.nextState(
                        grids[curr][outer][inner],
                        getAliveCount(getNeighborPoints(outer, inner)));
            }
        }
        curr = next;
    }

    /**
     * Returns the minimum co-ordinate of a neighbor of a point.
     * 
     * @param coord
     *            The co-ordinate of the point in question.
     * @param size
     *            The size of the co-ordinate's dimension.
     */
    private int getMinCoord(final int coord, final int size) {
        return coord > 0
                ? coord - 1
                : 0;
    }

    /**
     * Returns the maximum co-ordinate of a neighbor of a point.
     * 
     * @param coord
     *            The co-ordinate of the point in question.
     * @param size
     *            The size of the co-ordinate's dimension.
     */
    private int getMaxCoord(final int coord, final int size) {
        return coord < size - 1
                ? coord + 1
                : size - 1;
    }

    /**
     * Computes the neighboring points of a point.
     * 
     * @param outer
     *            The outer co-ordinate of the point in question.
     * @param inner
     *            The inner co-ordinate of the point in question.
     * @return The co-ordinates of the neighboring points of the point in
     *         question in the order [point][outer,inner].
     */
    private int[][] getNeighborPoints(final int outer, final int inner) {
        /*
         * NB: Impermeable boundary
         */
        final int minOuter = getMinCoord(outer, outerSize);
        final int maxOuter = getMaxCoord(outer, outerSize);
        final int minInner = getMinCoord(inner, innerSize);
        final int maxInner = getMaxCoord(inner, innerSize);
        final int n = (1 + maxOuter - minOuter) * (1 + maxInner - minInner) - 1;
        final int[][] coords = new int[n][2];
        int i = 0;
        for (int out = minOuter; out <= maxOuter; out++) {
            for (int in = minInner; in <= maxInner; in++) {
                if (!(out == outer && in == inner)) {
                    coords[i][0] = out;
                    coords[i][1] = in;
                    i++;
                }
            }
        }
        return coords;
    }

    /**
     * Returns the number of currently alive points in a list of points.
     * 
     * @param points
     *            Co-ordinates of the points in question in the order
     *            [point][outer,inner]
     * @return The number of given points that are currently alive.
     */
    private int getAliveCount(final int[][] points) {
        int n = 0;
        for (final int[] coords : points) {
            if (grids[curr][coords[0]][coords[1]]) {
                n++;
            }
        }
        return n;
    }
}
