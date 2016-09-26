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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import library.tests.BooksTest;

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class UserInterface {

    Scanner userSays;
    
    UserInterface(){
        userSays = new Scanner(System.in);
    }
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        
        BooksTest test = new BooksTest();
         
        Menu menu = new Menu();
        CollectionOfBooks books = test.BooksTest();
        menu.theShowMustGoOn();
        
        
    }
    
}
