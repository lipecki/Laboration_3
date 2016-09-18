
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
        this(1, 1);
    }
    public Circle(double height, double width)
    {
        this.height = height;
        this.width = width;
        this.setX(0);
        this.setY(0);
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
    public void paint(GraphicsContext gx)
    {
        gx.setFill(this.getColor());
        gx.fillOval(this.getX(), this.getY(), this.height, this.width);
    }
    
        /**
     * Move the shape a distance depending on the elapsed time in nanoseconds.
     * NB - the velocitey is measured in pixels/second.
     *
     * @param elapsedTimeNs the elapsed time in nanoseconds.
     */
    @Override
    public void move(long elapsedTimeNs) {
        this.setX(this.getDx() * elapsedTimeNs / BILLION);
        this.setY(this.getDy() * elapsedTimeNs / BILLION);
    }
    
    
    @Override
    public String toString(){
        return "X: " + this.getX() + ", Y: " + this.getY() + ", Width: " + this.width + ", Height: " + this.height;
    }
}
