class View {
    /**
     * The size of the X (inner) dimension.
     */
    private final int sizeX;
    /**
     * The size of the Y (outer) dimension.
     */
    private final int sizeY;

    View(final int sizeX, final int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    /**
     * Displays points that are alive.
     * 
     * @param points
     *            2-D co-ordinates (X dimension is the inner dimension) of live
     *            points (all others are assumed to be dead).
     */
    void display(final Heartbeat heartbeat) {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                System.out.print(heartbeat.isAlive(x, y)
                        ? '#'
                        : ' ');
            }
            System.out.println();
        }
    }
}
