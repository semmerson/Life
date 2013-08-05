/**
 * Copyright 2013 University Corporation for Atmospheric Research.  All rights
 * reserved.  See file LICENSE in the top-level source-directory for licensing
 * information.
 */

/**
 * Indicates if a point is alive or dead.
 * 
 * @author Steven R. Emmerson
 */
interface Heartbeat {
    /**
     * Indicates if a point is alive or dead.
     * 
     * @param x
     *            X co-ordinate.
     * @param y
     *            Y co-ordinate.
     * @return true if and only if the point is alive.
     */
    boolean isAlive(int x, int y);
}
