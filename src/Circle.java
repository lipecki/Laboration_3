
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
    /**
     * Creates a new black, filled circle with width and height set as 10
     */
    public Circle(){
        this(10, 10, Color.BLACK, true);
    }
    /**
     * Creates a new fillable circle with desired width, height and color.
     * @param width The width of the circle
     * @param height The height of the circle
     * @param color The color of the circle
     * @param filled Whether the circle is filled or not
     */
    public Circle(double width, double height, Color color, boolean filled)
    {
        super(width, height, color);
        this.setFilled(filled);
        this.setX(0);
        this.setY(0);
    }
    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return this.width;
    }
    /**
     * Sets the new height of the circle
     * @param height 
     */
    public void setHeight(double height){
        this.height = height;
    }
    /**
     * Sets the new width of the circle
     * @param width 
     */
    public void setWidth(double width){
        this.width = width;
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
            gc.fillOval(this.getX(), this.getY(), this.width, this.height);
        }
        else {
            gc.setStroke(this.getColor());
            gc.strokeOval(this.getX(), this.getY(), this.width, this.height);
        }
    }
    
    @Override
    public String toString(){
        return "X: " + this.getX() + ", Y: " + this.getY() + ", Width: " + this.width + ", Height: " + this.height;
    }
    
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
        } else if (x + width > boxWidth) {
            this.setVelocity(-Math.abs(dx), dy);
        }
        if (y < boxY) {
            this.setVelocity(dx, Math.abs(dy));
        } else if (y + height > boxHeight) {
            this.setVelocity(dx, -Math.abs(dy));
        }
    }
}
