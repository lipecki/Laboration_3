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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import library.tests.BooksTest;

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class UserInterface {
    
    UserInterface() throws FileNotFoundException{
         

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        BooksTest test = new BooksTest();
        
        //menu();
        
    }
    
    public void addBook(Book book){
        
    }
    
    public static void menu(){
        System.out.println("Menu");
        for(Enum e: Menu.values()) System.out.println("\t" + e);
    }
    
    public enum Menu {
    ShowLibrary, SearchForBook, SearchByAuthor ;
    }
    
}
