package library.tests;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import library.Author;
import library.Book;

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
public class BooksTest {
    public BooksTest() throws FileNotFoundException{
        
        File inputFile;
        Scanner readFile;
        inputFile = new File("src/library/Filename.txt");
        readFile = new Scanner(inputFile);
        ArrayList<Book> books = new ArrayList();
        books.add(new Book(readFile.nextLine()));
        
        Author Johan = new Author("Johan Lipecki");
        System.out.println(Johan.firstname());
    }
}
