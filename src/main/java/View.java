import net.jcip.annotations.NotThreadSafe;

/**
 * Copyright 2013 University Corporation for Atmospheric Research. All rights
 * reserved. See file LICENSE in the top-level source-directory for licensing
 * information.
 */

/**
 * The "Game of Life" display view.
 * <p>
 * Instances are thread-compatible but not thread-safe.
 * 
 * @author Steven R. Emmerson
 */
@NotThreadSafe
class View {
    /**
     * The size of the inner dimension.
     */
    private final int innerSize;
    /**
     * The size of the Y (outer) dimension.
     */
    private final int outerSize;

    /**
     * Constructs from the size of the inner and outer dimensions.
     * 
     * @param outerSize
     *            The size of the outer dimension.
     * @param innerSize
     *            The size of the inner dimension.
     * @throws IllegalArgumentException
     *             if innerSize < 0 || outerSize < 0
     */
    View(final int outerSize, final int innerSize) {
        if (innerSize < 0 || outerSize < 0) {
            throw new IllegalArgumentException("innerSize=" + innerSize
                    + "; outerSize=" + outerSize);
        }
        this.innerSize = innerSize;
        this.outerSize = outerSize;
    }

    /**
     * Displays points that are alive.
     * 
     * @param heartbeat
     *            An object that indicates if a point is alive or dead.
     */
    void display(final Heartbeat heartbeat) {
        for (int outer = 0; outer < outerSize; outer++) {
            for (int inner = 0; inner < innerSize; inner++) {
                System.out.print(heartbeat.isAlive(outer, inner)
                        ? '#'
                        : ' ');
            }
            System.out.println();
        }
    }
}
