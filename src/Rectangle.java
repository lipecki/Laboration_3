
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Constructor for a filled black triangle of width and height 20px
 * @author Viggo & Johan
 */
public class Rectangle extends FillableShape {
    double width, height;
    
    public Rectangle(){
        super();
        init(20.0, 20.0);
    }

    /**
     * Constructor for a filled or an unfilled rectangle
     * @param height
     * @param width
     * @param color of filled rectangle
     * @param filled
     */
    public Rectangle(double x, double y,double width, double height, Color color, boolean filled)
    {
        super(x, y,color, filled);
        init(width,height);
    }
    
    private void init(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    /**
     * @return rectangle height
     */
    public double getHeight(){
        return this.height;
    }
    
    /**
     * @return rectangle width
     */
    public double getWidth(){
        return this.width;
    }
    
    /**
     * @param height 
     */
    public void setHeight(double height){
        this.height = height;
    }
    
    
    public void setWidth(double width){
        this.width = width;
    }
    
    /** Draws a filled or unfilled rectangle
     * @param gc GraphicsContext object
     */
    @Override
    public void paint(GraphicsContext gc)
    {
        if(this.filled) {
            gc.setFill(this.getColor());
            gc.fillRect(this.getX(), this.getY(), this.height, this.width);
        }
        else {
            gc.setStroke(this.getColor());
            gc.strokeRect(this.getX(), this.getY(), width, height);
        }
    }
    
    @Override
    public String toString(){
        return "X: " + this.getX() + ", Y: " + this.getY() + ", Width: " + this.width + ", Height: " + this.height;
    }
    
    /**
     * Constrains the shape inside the given area/box, by bouncing it off att
     * the edges.
     *
     * @param boxX upper left corner of the "box"
     * @param boxY upper left corner of the "box"
     * @param boxWidth
     * @param boxHeight
     */
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
