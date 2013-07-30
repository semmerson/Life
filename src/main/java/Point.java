/**
 * An immutable integral 2-D point.
 * 
 * @author emmerson
 *
 */
final class Point {
    private final int x;
    private final int y;

    Point(final int x, final int y) {
    	this.x = x;
    	this.y = y;
    }
    
    int getX() {
    	return x;
    }
    
    int getY() {
    	return y;
    }
}
