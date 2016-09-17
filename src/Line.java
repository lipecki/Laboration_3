
import java.util.ArrayList;
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
    private List<Double> x, y;
    private List<Point> line;
    
    public Line(){
        super();
    }
    
    public Line(double x1, double y1, double x2, double y2){
        super(x1, y1, Color.BLACK);
        init(new Point(x1,y1),new Point(x2,y2));
    }
    /**
     * Constructor for a list of coordinate pairs 
     * that make up a line connecting the coordinates
     * @param xy a list of x- and y-coordinate pairs
     */
    public Line(double ...xy){
        super(xy[0],xy[1], Color.BLUE);
        assert (xy.length%2 == 0);
        
        List<Point> list = new ArrayList<>(xy.length);
        for(int i = 0; i < xy.length -1; i += 2) 
            list.add(new Point(xy[i],xy[i+1]));
        
        init((Point[]) list.toArray());    
    }
    
    private void init(Point ...points){
        this.line = new LinkedList<>();
        this.x = new ArrayList<Double>(points.length);
        this.y = new ArrayList<Double>(points.length);
        for(Point p: points){
            this.line.add(p);
            this.x.add(p.getX());
            this.y.add(p.getY());   
        }
        
    }
    
    
    public double getX(int i){
        return this.x.get(i);
    }
    
    public double getY(int i){
        return this.y.get(i);
    }
    
    public double getX2(){
        return x.get(1);
    }
    
    public double getY2(){
        return y.get(1);
    }
    
    public void setX2(double x2){
        this.x.set(1,x2);
        this.x2 = x2;
    }
    
    public void setY2(double y2){
        this.y.set(1,y2);
        this.y2 = y2;
    }
    
    public double getLength(){
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
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        for(int i = 0; i < line.size() -1; i++){
            gc.strokeLine(line.get(i).getX(), line.get(i).getY(),
                    line.get(i+1).getX(), line.get(i+1).getY());
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

        
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(this.getClass().getName());
        for(double x: this.x && double y: this.y){
            info.append(String.format(": x%d = %.2f, y%d = %.2f",this.x.indexOf(x)+1,x,this.y.indexOf(y)+1,y);
        }
        info.append(", color=" + this.getColor());
        return info;
    }
}
