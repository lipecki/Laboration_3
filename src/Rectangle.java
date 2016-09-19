
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
public class Rectangle extends FillableShape {
    
    public Rectangle(){
        this(20, 20, Color.BLACK, true);
    }

    /**
     *
     * @param height
     * @param width
     * @param color
     * @param filled
     */
    public Rectangle(double width, double height, Color color, boolean filled)
    {
        super(width, height);
        this.setColor(color);
        this.setFilled(filled);
        this.setVelocity(50, 100);
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
        if(this.filled) {
            gc.setFill(this.getColor());
            gc.fillRect(this.getX(), this.getY(), this.height, this.width);
        }
        else gc.strokeRect(this.getX(), this.getY(), width, height);
    }
    
    @Override
    public String toString(){
        return "X: " + this.getX() + ", Y: " + this.getY() + ", Width: " + this.width + ", Height: " + this.height;
    }
    
    @Override
    public void constrain(double boxX, double boxY,             
            double boxWidth, double boxHeight) {
            
        double x = this.getX();
        double y = this.getY();
            
        double dx = this.getDx();
        double dy = this.getDy();
        // If outside the box - calculate new dx and dy
        if (x <= boxX) {
            this.setVelocity(Math.abs(dx), dy);
        } else if (x + width > boxWidth) {
            this.setVelocity(-Math.abs(dx), dy);
        }
        dx = this.getDx();
        if (y <= boxY) {
            this.setVelocity(dx, Math.abs(dy));
        } else if (y + height > boxHeight) {
            this.setVelocity(dx, -Math.abs(dy));
        }
    }
}
