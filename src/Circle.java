
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
    private double height, width;
    public Circle(){
        this(1, 1, Color.BLACK, true);
    }
    public Circle(double width, double height, Color color, boolean filled)
    {
        super(width, height);
        this.setFilled(filled);
        this.setColor(color);
        this.setX(0);
        this.setY(0);
        this.setVelocity(100, 100);
    }
    
    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return this.width;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width){
        this.width = width;
    }
    @Override
    public void paint(GraphicsContext gc)
    {
        gc.setFill(this.getColor());
        gc.fillOval(this.getX(), this.getY(), this.height, this.width);
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
