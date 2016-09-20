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

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class Author {
    private final String lastname;
    private final String firstname;
    private ArrayList<String> names;
    private final String name;
    public Author(String name)
    {
        this.name = name;
        
        names = new ArrayList<>();
        for(String s: name.split(" ", 5)) names.add(s);
        
        if(name.contains(" ")) {
            firstname = names.get(0);
            lastname = names.get(names.size() - 1);
        }
        else { firstname = name; lastname = null;}
        
    }
    public String getName(){
        return this.name;
    }
    
    public String lastname(){
        if(lastname.isEmpty()) return null;
        return this.lastname;
    }
    
    public String firstname(){
        if(firstname.isEmpty()) return null;
        return this.firstname;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
