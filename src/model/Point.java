package model;

/**
 * A representation of a point
 * 
 * @author Anders Lindström <anderslm@kth.se>
 * modified by Johan Lipecki <lipecki@kth.se
 */
public class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean equals(Object other) {
        if (other instanceof Point) {
            Point p = (Point) other;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }

    public Point makeCopy() {
        return new Point(this.x, this.y);
    }

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", x , y);
    }
}
