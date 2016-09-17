
import java.util.LinkedList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * [Project] license
 * 
 * Copyright © 2016 Johan Lipecki
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class Line extends Shape{
    private double x2, y2;
    private double [] x, y;
    private List<Point> line;
    
    public Line(){
        super();
    }
    
    public Line(double x1, double y1,double x2, double y2){
        super(x1,x2, Color.BLUE);
        init(new Point(x1,y2),new Point(x2,y2));
        this.x2 = x2;
        this.y2 = y2;
        
    }
    
    private void init(Point ...points){
        this.line = new LinkedList<>();
        for(Point p: points) line.add(p);
        //if( sista punkten är utanför) reflektera linjen
    }
    
    public double getX2(){
        return this.x2;
    }
    
    public double getY2(){
        return this.y2;
    }
    
    public void setX2(double x2){
        this.x2 = x2;
    }
    
    public void setY2(double y2){
        this.y2 = y2;
    }
    
    public double getDirection(){
        return Math. dy/dx;
    }
    
    public double getLength(){
        return Math.hypot(super.getDx(), super.getDy());
    }
    
    @Override
    public void paint(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        for(Point p: line.subList(0, 0))gc.strokeLine(x1, y1, x2, y2);
    }
    
        /**
     * Constrains the shape inside the given area/box, by bouncing it off att
     * the edges. The shape is considered a point in this implementation which
     * causes erratic behaviour at the left and bottom edges. Subtypes must
     * override this method to correct this behaviour.
     *
     * @param boxX upper left corner of the "box"
     * @param boxY upper left corner of the "box"
     * @param boxWidth
     * @param boxHeight
     */
    @Override
    public void constrain(
            double boxX, double boxY, 
            double boxWidth, double boxHeight) {

        
    }

    @Override
    public String toString() {
        String info
                = this.getClass().getName() + ": x1=" + super.getX() + ", y1=" + super.getY()
                + "x2=" + x2 + ", y2=" + y2
                + ", color=" + this.getColor();
        return info;
    }
}
