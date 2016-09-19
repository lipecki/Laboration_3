/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viggo
 */
public abstract class FillableShape extends Shape{
    protected boolean filled;
    protected double width, height;
    protected FillableShape(){
        this(10, 10);
    }
    protected FillableShape(double width, double height)
    {
        this.width = width;
        this.height = height;
        this.filled = true;
    }
    public boolean isFilled(){
        return this.filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
}
