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
import java.util.List;

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class Book implements Comparable{

    private final String isbn;
    private final String title;
    private final int edition;
    private final double price;
    private List<String> book;
    private ArrayList<Author> authors;
    
    public Book(String isbn, String title, int edition, double price)
    {
        init();
        book.add(0, this.isbn = isbn);
        book.add(1, this.title = title);
        book.add(2, Integer.toString(this.edition = edition));
        book.add(3, Double.toString(this.price = price));
    }
    
    public Book(String s){
        init();
        book = Arrays.asList(s.split(";", 5));
        this.isbn = book.get(0);
        this.title = book.get(1);
        this.edition = Integer.decode(book.get(2));
        this.price = Double.valueOf(book.get(3));
        
    }
    
    private void init(){
        book = new ArrayList<>();
        authors = new ArrayList();
    }
    
    public String getISBN()
    {
        return this.isbn;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public int getEdition()
    {
        return this.edition;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public void addAuthor(Author author)
    {
       authors.add(author);
       
    }
    public ArrayList<Author> getAuthors()
    {
        return (ArrayList<Author>) authors.clone();
    }
    
    @Override
    public String toString(){
        StringBuilder book = new StringBuilder();
        for(int i = 0; i < this.book.size(); i++){
            try{
                book.append(BookValue.values()[i]).append(": ").append(this.book.get(i)).append(";");
            }
            catch (NullPointerException nul) {
                System.out.println("No Author registered");
            }
        }
        return book.toString();
        //this.title
        //this.edition
        //is.price
    }
    
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public enum BookValue{
        ISBN, Title, Edition, Price, Author;
    }
    
}
