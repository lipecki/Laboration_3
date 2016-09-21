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
import java.util.Iterator;
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
    private ArrayList<String> book;
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
        book.addAll(Arrays.asList(s.split(";", 10)));
        this.isbn = book.get(0);
        this.title = book.get(1);
        this.edition = Integer.decode(book.get(2));
        this.price = Double.valueOf(book.get(3));
        if(book.size()>4) 
            for (String z : book.subList(4, book.size())) {
                authors.add(new Author(z));
        }
        
    }
    
    private void init(){
        book = new ArrayList<>();
        authors = new ArrayList<>();
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
       this.book.add(author.getName()); //This isn't working
       
    }
    public ArrayList<Author> getAuthors()
    {
        return (ArrayList<Author>) authors.clone();
    }
    
    @Override
    public String toString(){
        StringBuilder book = new StringBuilder(BookValue.ISBN + ": " + this.book.get(0));
        for(int i = 1; i < this.book.size(); i++){
            try{
                book.append(";").append(BookValue.values()[i]).append(": ").append(this.book.get(i));
            }
            catch (ArrayIndexOutOfBoundsException moreThanOneAuthor) {
                int c = book.lastIndexOf(";"); 
                book.deleteCharAt(c);
                book.append(", ").append(this.book.get(i));
            }
        }
        return book.toString();
    }
    
    @Override
    public int compareTo(Object o) {
        if (this.equals(o)) return 0;
        if(o instanceof Book){
            return this.title.compareTo(((Book) o).title);
        } 
        else
            throw new UnsupportedOperationException("Not a Book object");
    }
    
    public enum BookValue{
        ISBN, Title, Edition, Price, Author;
    }
    
}
