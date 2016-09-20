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
import library.tests.BooksTest;

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class UserInterface {

    private String menu;
    
    UserInterface(){
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //BooksTest test = new BooksTest();
        menu();
        
    }
    
    public static void menu(){
        for(Enum e: Menu.values()) System.out.println(e);
    }
    
    public enum Menu {
    ShowLibrary, SearchForBook, SearchByAuthor ;
    }
    
}
