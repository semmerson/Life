/**
 * Copyright 2013 University Corporation for Atmospheric Research.  All rights
 * reserved.  See file LICENSE in the top-level source-directory for licensing
 * information.
 */

/**
 * Indicates if a 2-D integral point is alive or dead.
 * 
 * @author Steven R. Emmerson
 */
interface Heartbeat {
    /**
     * Indicates if a 2-D integral point is alive or dead.
     * 
     * @param inner
     *            Inner co-ordinate.
     * @param outer
     *            Outer co-ordinate.
     * @return true if and only if the point is alive.
     */
    boolean isAlive(int inner, int outer);
}
