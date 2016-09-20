/*
 * Laboration 3 license
 * 
 * Copyright © 2016 Johan Lipecki & Viggo Lundén
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

package library;

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class Author {
    private String name;
    private String lastname;
    private String firstname;
    private String [] names;
    public Author(String name)
    {
        this.name = name;
        this.names = name.split(" ", 5);
        if(name.contains(" ")) {
            firstname = names[0];
            lastname = names[names.length -1];
        }
        else { firstname = name; lastname = "";}
        
    }
    public String getName(){
        return this.name;
    }
    
    public String lastname(){
        if(lastname.isEmpty()) return "";
        return this.lastname;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
