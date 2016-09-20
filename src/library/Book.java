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

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class Book implements Comparable{

    private String isbn;
    private String title;
    private int edition;
    private double price;
    private ArrayList<Author> authors;
    
    public Book(String isbn, String title, int edition, double price)
    {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
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
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
