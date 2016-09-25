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
import java.util.Collections;

/**
 *
 * @author Johan Lipecki <lipecki@kth.se>
 */
public class CollectionOfBooks implements Serializable {
    private ArrayList<Book> books;
    /**
     * Creates an empty collection of books
     */
    public CollectionOfBooks(){
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
     * Adds an array of books to the collection of books
     * @param books 
     */
    public void addBooks(Book ...books){
        for (Book b : books)
        {
            this.books.add(b);
        }
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
     * @return ArrayList<Book>
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
    
    /**
     * Returns all books with the specified ISBN. NB! It does <b>not</b> return clones.
     * @param isbn The specified isbn
     * @return ArrayList<Book>
     */
    public ArrayList<Book> getBooksByISBN(String isbn)
    {
        ArrayList<Book> books_by_isbn = new ArrayList<>();
        for (Book b : books)
        {
            if (b.getISBN().equals(isbn)) books_by_isbn.add(b);
        }
        return books_by_isbn;
    }
    
    /**
     * Returns all books with the specified Author. NB! It does <b>not</b> return clones.
     * @param author
     * @return ArrayList<Book>
     */
    public ArrayList<Book> getBooksByAuthor (String author) 
    {
        ArrayList<Book> books_by_author;
        ArrayList<Author> authors;
        ArrayList<String> authorNames;
        
        books_by_author = new ArrayList<>();
        authorNames = new ArrayList();
        
        for (Book b : books)
        {
            authors = b.getAuthors();
            for(Author a: authors){
                authorNames.add(a.getName());
                if(a.firstname() != null) authorNames.add(a.firstname());
                if(a.lastname() != null) authorNames.add(a.lastname());
            }
            if (authors.contains(new Author(author)) || authorNames.contains(author)) books_by_author.add(b);
            authorNames.clear();
        }
        return books_by_author;
    }
}
