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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents an author, with first and last name
 * @author Viggo Lundén <vlunden@kth.se>, Johan Lipecki <lipecki@kth.se>
 */
public class Author implements Serializable {
    private final String lastname;
    private final String firstname;
    private ArrayList<String> names;
    private final String name;
    
    /**
     * Creates a new author
     * @param name The first and last name of the author, separated with whitespace(s)
     */
    public Author(String name)
    {
        this.name = name;
        
        names = new ArrayList<>();
        names.addAll(Arrays.asList(name.split(" ", 5)));
        
        if(name.contains(" ")) {
            firstname = names.get(0);
            lastname = names.get(names.size() - 1);
        }
        else { firstname = name; lastname = null;}
        
    }
    /**
     * 
     * @return Author's full name
     */
    public String getName(){
        return this.name;
    }
    /**
     * 
     * @return Author's last name
     */
    public String lastname(){
        if(lastname.isEmpty()) return null;
        return this.lastname;
    }
    /**
     * 
     * @return Author's first name
     */
    public String firstname(){
        if(firstname.isEmpty()) return null;
        return this.firstname;
    }
    /**
     * 
     * @return Author's full name
     */
    @Override
    public String toString(){
        return name;
    }
}
