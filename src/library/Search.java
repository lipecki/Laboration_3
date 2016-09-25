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

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class Search {
    Scanner userSays = new Scanner(System.in);
    CollectionOfBooks books;
    ArrayList<Book> result;
    
    public Search(CollectionOfBooks books){
        this.books = books;
    }
    
    private enum searchValues{
        ISBN,Author,Title;
    }
    
    public char promptUser() {
        printSearchMenu();
        String selection;
        selection = userSays.nextLine();        
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
    
    public ArrayList<Book> search(CollectionOfBooks books) {
        //ArrayList<Book> result;
        char select = ' ';
        
        if(select != 'N'){
            select = promptUser();
            result = getQuery(select);    
        }
        return result;
    }
    
    private ArrayList<Book> getQuery(char select){
        //ArrayList<Book> result;
        System.out.println("Please type query: ");
            switch(select) {
                case 'T':   result = getResults(searchValues.Title); break;
                case 'I':   result = getResults(searchValues.ISBN); break; 
                case 'A':   result = getResults(searchValues.Author); break;
                case 'N':   result = getResults(null); break;
                default:    System.out.println("Sorry, I must have misread. Please select again!");
            }
            return result;
    }
    
    private ArrayList<Book> getResults(searchValues searchType){
        //ArrayList<Book> result;
        String search = userSays.nextLine();
        switch(searchType){
            
            case ISBN  : result = books.getBooksByISBN(search); break;
            case Author: result = books.getBooksByAuthor(search); break;
            case Title : result = books.getBooksByTitle(search); break;
            default:    result = null;    
        }
        return result;
    }
    
    
}
