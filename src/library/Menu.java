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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import library.Search.*;

public class Menu {

    private CollectionOfBooks books;
    private Scanner userSays;

    public Menu() {
    	userSays = new Scanner(System.in);
        books = FileHelper.read();
    }
    
    /**
     *The menu loop starts running
     */
    public void theShowMustGoOn(CollectionOfBooks books){
        char select = ' ';
        String selection;
        
        while(select != 'E'){
            printMenu();
            selection = userSays.nextLine();
            select = selection.toUpperCase().charAt(0);
            
            switch(select) {
                case 'A':   addBook(books); break;
                case 'R':   removeBook(books); break;
                case 'S':   search(books); break;
                case 'L':   showLibrary(books); break;
                case 'E':   for(int i = 0; i < 30; i++) System.out.println("");
                            System.out.println("End of line");
                            break;
                            
                default:    System.out.println("Sorry, I must have misread. Please select again!");
            }
            
        }
    }

    private static void printMenu(){
        String [] menu = {
                "\n------Menu------",
                "A: Add Book",
                "R: Remove Book",
                "S: Search",
                "L: Show Library",
                "E: End Of Line"};
        for(String s: menu) System.out.println(s);
    }

    private void search(CollectionOfBooks books) {
        ArrayList<Book> listOfBooks;
        
        Search find = new Search(books);
        //char c = find.promptUser();
        listOfBooks = find.search(books); 
        System.out.print(booksToTable(listOfBooks));
        
    }
    private void addBook(CollectionOfBooks books) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void removeBook(CollectionOfBooks books) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    private void showLibrary(CollectionOfBooks books) {
        String[] library = {
            "--\t--Library--\t--\n",
            "Author\t",
            "Title\t",
            "Edition\t",
            "Price\t",
            "ISBN\t"
        };
        for (String s : library)
        {
            System.out.print(s); 
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