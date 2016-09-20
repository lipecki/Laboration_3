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
package library;

import java.util.ArrayList;

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class CollectionOfBooks {
    private ArrayList<Book> books;
    /**
     * Creates an empty collection of books
     */
    public CollectionOfBooks()
    {
        books = new ArrayList<>();
    }
    /**
     * Adds a book to the collection of books
     * @param book 
     */
    public void addBook(Book book)
    {
        books.add(book);
    }
    /**
     * Removes a book reference from the collection of books.
     * @param book
     * @return True if the book was found and removed, false if it wasn't found
     */
    public boolean removeBook(Book book)
    {
        if (books.contains(book))
        {
            books.remove(book);
            return true;
        }
        return false;
    }
    /**
     * Returns a clone of the collection of books
     * @return 
     */
    public ArrayList<Book> getBooks()
    {
        return (ArrayList<Book>) books.clone();
    }
    
    /**
     * Returns all books with the specified title. NB! It does <b>not</b> return clones.
     * @param title The specified title
     * @return 
     */
    public ArrayList<Book> getBooksByTitle(String title)
    {
        ArrayList<Book> books_by_title = new ArrayList<>();
        for (Book b : books)
        {
            if (b.getTitle().equals(title)) books_by_title.add(b);
        }
        return books_by_title;
    }
}
