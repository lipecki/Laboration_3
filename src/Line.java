import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.MissingResourceException;
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
    private List<Point> line;
    private List<Point> direction;
    
    public Line(){
        super();
        Point []p = {new Point(this.getX(),this.getY()),new Point(300.0,300.0)};
        init(p);
    }
    
    /**
     * Constructor for a list of coordinate pairs 
     * that make up a line connecting the coordinates
     * @param xy a list of x- and y-coordinate pairs
     */
    public Line(double ...xy){
        super(xy[0],xy[1], Color.BLUE);
        if(xy.length%2 != 0) 
            throw new MissingResourceException("One argument missing from (x,y)-coordinate",
                    "Line","y-coordinate");
        
        List<Point> list = new ArrayList<>(xy.length);
        if(xy.length==2)list.add(new Point(0.0,0.0));
        
        for(int i = 0; i < xy.length -1; i += 2) 
            list.add(new Point(xy[i],xy[i+1]));
        
        this.init(list.toArray(new Point[list.size()]));    
    }
   
    
    private void init(Point []points){
        this.line = new LinkedList<>();
        this.line.addAll(Arrays.asList(points));
        
        this.setVelocity(50,100);
        this.direction = new ArrayList();
        for(Point p: this.line)
           this.direction.add(new Point(this.getDx(),this.getDy()));
    }
    
    
    public double getX(int i){ 
        return this.line.get(i).getX();
    } 
    
    public double getY(int i){
        return this.line.get(i).getY();
    } 
    
    public double getX2(){ 
        return  this.line.get(1).getX();
    } 
    
    public double getY2(){ 
        return this.line.get(1).getY();
    } 
    
    public void setX2(double x2){ 
       this.line.get(1).setX(x2);
    } 
    
    public void setY2(double y2){ 
        this.line.get(1).setY(y2);
    } 
    
    private double getLength(){
        double sum = 0.0;
        for(int i = 0; i < (this.line.size() - 1); i++){ 
            double dx = Math.abs(line.get(i+1).getX() - line.get(i).getX());
            double dy = Math.abs(line.get(i+1).getY() - line.get(i).getY()); 
            sum += Math.hypot(dx, dy); 
        } 
        return sum;
    } 
    
    @Override
    public void paint(GraphicsContext gc){
        //gc.setStroke(Color.BLUE); 
        gc.setLineWidth(2); 
        for(int i = 0; i < line.size() -1; i++){ 
            gc.strokeLine(line.get(i).getX(), line.get(i).getY(),
                    line.get(i+1).getX(), line.get(i+1).getY());
        } 
    }
    
    /**
     * Move the line a distance depending on the elapsed time in nanoseconds.
     * NB - the velocitey is measured in pixels/second.
     *
     * @param elapsedTimeNs the elapsed time in nanoseconds.
     */
    @Override
    public void move(long elapsedTimeNs) {
        for(int i = 0; i < this.line.size(); i++){
            double d = this.line.get(i).getX();
            d += this.direction.get(i).getX() * elapsedTimeNs / BILLION;
            this.line.get(i).setX(d);
            
            d = this.line.get(i).getY();
            d += this.direction.get(i).getY() * elapsedTimeNs / BILLION;
            this.line.get(i).setY(d);
        }
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
        
        
        for(int i = 0; i < this.line.size(); i++) {
            double x = this.line.get(i).getX();
            double dx = this.direction.get(i).getX();
            if(x <= boxX)  {
                //this.line.get(i).setX(boxX);
                dx = Math.abs(dx);
                this.direction.get(i).setX(dx);
            } else if (x >= boxWidth) {
                //this.line.get(i).setX(boxWidth);
                this.direction.get(i).setX(-dx);
            }
                
            double y = this.line.get(i).getY();
            double dy = this.direction.get(i).getY();
            if(y <= boxY)  {
                //this.line.get(i).setY(boxY);
                dy = Math.abs(dy);
                this.direction.get(i).setY(dy);
            } else if (y >= boxHeight) {
                //this.line.get(i).setY(boxHeight);
                this.direction.get(i).setY(-dy);
            }
        }
        
    }
    
    @Override
    public String toString() { 
        StringBuilder info = new StringBuilder();
        info.append(this.getClass().getName()); 
        for(Point p: this.line)
            info.append(p.toString()); 
        info.append(", color=").append(this.getColor());
        return info.toString(); 
    } 
}