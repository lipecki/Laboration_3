/*
 * Laboration 3 license
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
package library;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class Search {
    
    BufferedReader inPut;
    PrintStream outPut;
    CollectionOfBooks books;
    ArrayList<Book> result;
    
    public Search(CollectionOfBooks books, InputStream in, OutputStream out){
        this.books = books;
        inPut = new BufferedReader(new InputStreamReader(in));
        outPut = new PrintStream(out);
    }
    
    private enum searchValues{
        ISBN,Author,Title;
    }
    
    public char promptUser() throws IOException {
        printSearchMenu();
        String selection;
        selection = inPut.readLine();        
        if(selection.isEmpty()) selection = String.valueOf(promptUser());
        return selection.toUpperCase().charAt(0);
    }
    
    private static void printSearchMenu(){
        String [] menu = {
                "-- --Search Menu-- --",
                "T: Title search",
                "I: ISBN search",
                "A: Author search",
                "N: Nevermind, Please take me back!"};
        for(String s: menu) System.out.println("\t" + s);
    }
    
    public ArrayList<Book> search(CollectionOfBooks books) throws IOException {
        //ArrayList<Book> result;
        char select = ' ';
        
        if(select != 'N'){
            select = promptUser();
            result = getQuery(select);    
        }
        return result;
    }
    
    private ArrayList<Book> getQuery(char select) throws IOException{
        //ArrayList<Book> result;
        while(result == null){
            switch(select) {
                case 'T':   result = getResults(searchValues.Title); break;
                case 'I':   result = getResults(searchValues.ISBN); break; 
                case 'A':   result = getResults(searchValues.Author); break;
                case 'N':   result = new ArrayList<>(); break;
                default:    System.out.println("Sorry, I must have misread. Please select again!");
                            String selection = inPut.readLine();
                            select = selection.toUpperCase().charAt(0);
                            
            }
        }
        return result;
    }
    
    private ArrayList<Book> getResults(searchValues searchType) throws IOException{
        //ArrayList<Book> result;
        System.out.println("Please type query: ");
        String search = inPut.readLine();
        switch(searchType){
            
            case ISBN  : result = books.getBooksByISBN(search); break;
            case Author: result = books.getBooksByAuthor(search); break;
            case Title : result = books.getBooksByTitle(search); break;
            default:    result = null;    
        }
        return result;
    }
    
    
}
