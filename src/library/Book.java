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

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a book
 * @author Johan Lipecki <lipecki@kth.se>, Viggo Lundén <vlunden@kth.se>
 */
public class Book implements Comparable<Book>, Serializable{

    private final String isbn;
    private final String title;
    private final int edition;
    private final double price;
    private ArrayList<String> book;
    private ArrayList<Author> authors;
    
    /**
     * 
     * @param isbn
     * @param title
     * @param edition
     * @param price 
     */
    public Book(String isbn, String title, int edition, double price)
    {
        init(isbn, title, edition, price);        
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
        authors = new ArrayList<>();
    }
    /**
     * 
     * @param isbn
     * @param title
     * @param edition
     * @param price 
     */
    private void init(String isbn, String title, int edition, double price){
        init();
        book.add(0,isbn);
        book.add(1,title);
        book.add(2, Integer.toString(edition));
        book.add(3, Double.toString(price));
    }
    
    /**
     * Placeholder book,
     * can be compared and thus also sorted.
     */
    public Book(){
        this(null,null,Integer.MAX_VALUE,Double.NaN);
        init();
    }
    
    /**
     * 
     */
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
    
    /**
     * 
     * @param author 
     */
    public void addAuthor(Author author)
    {
       authors.add(author);
       this.book.add(author.getName()); 
       
    }
    
    public ArrayList<Author> getAuthors()
    {
        return (ArrayList<Author>) authors.clone();
    }
    
    @Override
    public String toString(){
        StringBuilder book = new StringBuilder(this.book.get(0));
        for(int i = 1; i < this.book.size(); i++){
            if(i < 5) book.append(";").append(this.book.get(i));
            else {
                book.append(", ").append(this.book.get(i));
            }
        }
        return book.toString();
    }
    
    public int compareTo(Book o) throws NullPointerException {
        if (this == o) return 0;
        try{
            return this.title.compareTo(((Book) o).getTitle());
        }catch (NullPointerException nul){
            try{
                return this.edition - o.getEdition();
            } catch (NullPointerException Nul){
                return this.edition;
            }
        }
    }
    
    public enum BookValue{
        ISBN, Title, Edition, Price, Author;
    }
    
}
