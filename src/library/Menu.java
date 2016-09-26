package library;

/**
 * 
 *  *Följande alternativ ska minst finnas i menyn:
 *  •Lägga till böcker
 *  • Ta bort böcker
 *  • Söka efter titel, författare respektive ISBN.
 *  • Lista alla böcker.
 *  • Avsluta och skriva all information till fil.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import library.Book.BookValue;
import library.Search.*;

public class Menu {

    private CollectionOfBooks books;
    private BufferedReader userSays;
    private PrintStream outPut;
    
    public Menu() {
        this("books.ser", System.in, System.out);
    }
    /**
     * Prompts the user with a menu for navigating in the library. 
     * @param newSerializedLibrary the file, containing books, to be read
     * @param in the InputStream to read from
     * @param out the OutputStream to write to
     */
    public Menu(String newSerializedLibrary, InputStream in, OutputStream out) {
        userSays = new BufferedReader(new InputStreamReader(in));
        outPut = new PrintStream(out);
        books = FileHelper.read(newSerializedLibrary);
    }
    
    /**
     * The menu loop starts running.
     * @throws java.io.IOException if reading from the InputStream failed
     */
    public void theShowMustGoOn() throws IOException{
        char select = ' ';
        String selection;
        
        while(select != 'E'){
            printMenu();
            selection = userSays.readLine();
            if(!selection.isEmpty()) select = selection.toUpperCase().charAt(0);
            
            switch(select) {
                case 'A':   addBook(); break;
                case 'R':   removeBook(); break;
                case 'S':   search(); break;
                case 'L':   showLibrary(); break;
                case 'E':   for(int i = 0; i < 30; i++) outPut.println("");
                            outPut.println("End of line");
                            break;
                            
                default:    outPut.println("Sorry, I must have misread. Please select again!");
            }
            
        }
    }
    /**
     * Prints the main menu.
     */
    private void printMenu(){
        String [] menu = {
                "\n------Menu------",
                "A: Add Book",
                "R: Remove Book",
                "S: Search",
                "L: Show Library",
                "E: End Of Line"};
        for(String s: menu) outPut.println(s);
    }
    /**
     * Prompts the user with the interface for the search functionality.
     */
    private void search() {
        ArrayList<Book> listOfBooks;
        
        Search find = new Search(books);
        //char c = find.promptUser();
        listOfBooks = find.search(books); 
        if(listOfBooks != null) outPut.print(booksToTable(listOfBooks));
        
    }
    /**
     * Prompts the user with the interface to add a new book to the library. The new collection is then written to the file.
     */
    private void addBook() throws IOException {
        String isbn, title;
        int edition;
        double price;
        List<Author> authors = new ArrayList<>();
        
        outPut.println("ISBN:");
        isbn = userSays.readLine();
        outPut.println("Title:");
        title = userSays.readLine();
        outPut.println("Edition:");
        edition = Integer.parseInt(userSays.readLine());
        outPut.println("Price:");
        price = Double.parseDouble(userSays.readLine());
        int authorCount = 0;
        while (true)
        {
            authorCount++;
            outPut.println("(d for done) Author " + authorCount + ":");
            String name = userSays.readLine();
            if (name.equals("d")) break;
            authors.add(new Author(name));
        }
        Book book = new Book(isbn, title, edition, price);
        for (Author a : authors)
            book.addAuthor(a);
        books.addBook(book);
        FileHelper.write(books, "books.ser");
    }

    /**
     * Prompts the user with the interface that allows him or her to remove a book from the library. The new library is then written to the file.
     */
    private void removeBook() throws IOException {
        outPut.println("\nPlease enter ISBN of book to remove: ");
        String isbn = userSays.readLine();
        ArrayList<Book> buks = books.getBooksByISBN(isbn);
        if(buks != null)
            for(Book b: buks) 
                books.removeBook(b);
        FileHelper.write(books, "books.ser");
    }
    /**
     * Shows the library to the user.
     */
    private void showLibrary() {
            outPut.print("--\t--Library--\t--\n");
            for(Book.BookValue v: BookValue.values()){
                outPut.print(v + "\t\t");
                if(v != v.ISBN) outPut.print("\t");
            }
            for(Book b: books.getBooks()){
                outPut.println("");
                int i = 0;
                for(String s: b.toString().split(";")){
                    outPut.print(s);
                    if(s.length() < 8) outPut.print("\t\t");
                    else if(s.length() < 15) outPut.print("\t");
                    if(i != 0) outPut.print("\t");
                    i++;
                }
            }
            
            
    }
    
    private String bookStringToTable(String book){
        ArrayList<String> bookParts= new ArrayList();
        bookParts.addAll(Arrays.asList(book.split(";", 10)));
        
        StringBuilder string = new StringBuilder(Book.BookValue.ISBN + ": " + bookParts.get(0) + "\n");
        for(int i = 1; i < bookParts.size(); i++){
            if(i>4) string.append(", ").append(bookParts.get(i)).append("\n");
            else {
                string.append(Book.BookValue.values()[i]).append(": ");
                string.append(bookParts.get(i)).append("\n");
            }
        }
        return string.toString();
    }
    
    private String booksToTable(ArrayList<Book> books){
        StringBuilder book = new StringBuilder();
        for(Book b: books) {
            book.append("---------------\n");
            book.append(bookStringToTable(b.toString()));
        }
        return book.toString();
    }
}