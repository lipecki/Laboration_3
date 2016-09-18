
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
    public Circle(double height, double width, Color color, boolean filled)
    {
        this.height = height;
        this.width = width;
        this.setFilled(filled);
        this.setColor(color);
        this.setX(0);
        this.setY(0);
        this.setVelocity(1000, 1000);
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
}
