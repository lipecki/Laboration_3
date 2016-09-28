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
* Represents a book with values isbn, title, edition price and Author
 * @author Johan Lipecki <lipecki@kth.se> 
 * @author Viggo Lundén <vlunden@kth.se>
 */
public class Book implements Comparable<Book>, Serializable{

    private final String isbn;
    private final String title;
    private final int edition;
    private final double price;
    private ArrayList<String> book;
    private ArrayList<Author> authors;
    
    /**
     * A book object is instanciated
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
     * Initializes ArrayList<Author> authors, for authors 
     * and ArrayList<String> book, for book values, which is then filled 
     * with the given parameters
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
     * Initializes class lists for Book values and authors
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
     * Adds author to Book list of authors
     * @param author 
     */
    public void addAuthor(Author author)
    {
       authors.add(author);
       this.book.add(author.getName()); 
       
    }
    /**
     * 
     * @return a cloned ArrayList of Author(s)
     */
    public ArrayList<Author> getAuthors()
    {
        return (ArrayList<Author>) authors.clone();
    }
    
    /**
     * 
     * @return a semi-colon separated list of Book values, 
     * including authors, in the enum BookValues{} order: 
     * ISBN, Title, Edition, Price and Author(s)
     */
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
    
    /**
     * Compares book Titles
     * @param o
     * @return 0 if books are equal, 
     * otherwise a negative or positive comparative value
     * @throws NullPointerException 
     */
    @Override
    public int compareTo(Book o) throws NullPointerException {
        if (this == o) return 0;
        try{
            if(o.title != null) return this.title.compareTo(((Book) o).getTitle());
            else return this.edition - o.getEdition();
        }
        finally {}
    }
    
    public enum BookValues{
        ISBN, Title, Edition, Price, Author;
    }
    
}
