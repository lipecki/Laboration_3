
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viggo
 */
public class Circle extends FillableShape {
    private double diameter;
    /**
     * Creates a new black, filled circle with diameter set as 10
     */
    public Circle(){
        super();
        init(10);
    }
    /**
     * Creates a new fillable circle with desired diameter and color.
     * @param diameter
     * @param color The color of the circle
     * @param filled Whether the circle is filled or not
     */
    public Circle(double diameter, Color color, boolean filled)
    {
        super(0.0,0.0,color,filled);
        init(diameter);
    }
    
    private void init(double diameter){
        this.diameter = diameter;
    }
    public double getDiameter(){
        return this.diameter;
    }

    /**
     * Sets the new diameter of the circle
     * @param diameter
     */
    public void setDiameter(double diameter){
        this.diameter = diameter;
    }

    /**
     * Paints the circle with a GraphicsContext reference
     * @param gc GraphicsContext reference
     */
    @Override
    public void paint(GraphicsContext gc)
    {
        if (this.filled) {
            gc.setFill(this.getColor());
            gc.fillOval(this.getX(), this.getY(), this.diameter, this.diameter);
        }
        else {
            gc.setStroke(this.getColor());
            gc.strokeOval(this.getX(), this.getY(), this.diameter, this.diameter);

        }
    }
    
    @Override
    public String toString(){
        return "Upper left X: " + this.getX() + ", Upper left Y: " + this.getY() + ", Diameter: " + this.diameter;
    }
    /**
     * Bounces the circle off of the given "box" width and height
     * @param boxX
     * @param boxY
     * @param boxWidth
     * @param boxHeight 
     */
    @Override
        public void constrain(
            double boxX, double boxY, 
            double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        double x = this.getX();
        double y = this.getY();
        double dx = this.getDx();
        double dy = this.getDy();
        if (x < boxX) {
            this.setVelocity(Math.abs(dx), dy);
        } else if (x + diameter > boxWidth) {
            this.setVelocity(-Math.abs(dx), dy);
        }
        if (y < boxY) {
            this.setVelocity(dx, Math.abs(dy));
        } else if (y + diameter > boxHeight) {
            this.setVelocity(dx, -Math.abs(dy));
        }
    }
}
