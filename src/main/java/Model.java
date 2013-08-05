import net.jcip.annotations.NotThreadSafe;

/**
 * Instances are thread-compatible but not thread safe.
 * 
 * @author Steven R. Emmerson
 */
@NotThreadSafe
class Model {
    /**
     * The size of the inner dimension.
     */
    private final int innerSize;
    /**
     * The size of the outer dimension.
     */
    private final int outerSize;

    /**
     * Constructs from the sizes of the inner and outer dimensions.
     * 
     * @param innerSize
     *            The size of the inner dimension.
     * @param outerSize
     *            The size of the outer dimension.
     * @throws IllegalArgumentException
     *             if innerSize < 0 || outerSize < 0
     */
    Model(final int innerSize, final int outerSize) {
        if (innerSize < 0 || outerSize < 0) {
            throw new IllegalArgumentException("innerSize=" + innerSize
                    + "; outerSize=" + outerSize);
        }
        this.innerSize = innerSize;
        this.outerSize = outerSize;
    }

    /**
     * Returns a heartbeat object that indicates what points are alive.
     * 
     * @return an object that identifies the live points.
     */
    Heartbeat getHeartbeat() {
        return null;
    }

    /**
     * Advances the model one time-step.
     */
    void advance() {
    }
}
