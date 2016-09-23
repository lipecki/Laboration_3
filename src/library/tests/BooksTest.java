package library.tests;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import library.Author;
import library.Book;
import static library.UserInterface.*;
//import static library.UserInterface.convertStringToBook;

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
    public BooksTest() throws FileNotFoundException, IOException{
        
        File inputFile;
        Scanner readFile;
        inputFile = new File("src/library/Filename.txt");
        File outputFile = inputFile;
        readFile = new Scanner(inputFile);
        ArrayList<Book> books = new ArrayList();
        do{
            books.add(convertStringToBook(readFile.nextLine()));
        }while(readFile.hasNext());
        
        Author Johan = new Author("Viggo Lundén");
        books.get(0).addAuthor(Johan);
        //bok.addAuthor((Author) Johan);
        //System.out.println(bok);
        //books.set(0, bok);
        
        System.out.format("Compare the book: %d", books.get(0).compareTo(new Book()));
        
        System.out.println("\nBöcker:");
        for(Book b: books) {
            System.out.println("---------------");
            for(String s: b.toTable().split(";"))
                    System.out.println(s);
        }
        FileWriter fw = new FileWriter("src/library/newFile.txt");
        //FileWriter fw = new FileWriter(outputFile.getPath());
        
        for(Book b: books)
            fw.write(b.toString() + "\n");
        fw.close();
        
    }
}
