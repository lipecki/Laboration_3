
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
public abstract class FillableShape extends Shape{
    protected boolean filled;
    protected FillableShape(){
        super();
    }
    protected FillableShape(double x1, double y1, Color color, boolean filled){
        super(x1,y1,color);
        this.filled = filled;
    }
    public boolean isFilled(){
        return this.filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
}
