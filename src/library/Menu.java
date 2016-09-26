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
import java.util.List;
import java.util.Scanner;
import library.Book.BookValue;
import library.Search.*;

public class Menu {

    private CollectionOfBooks books;
    private Scanner userSays;

    public Menu() {
        this("books.ser");
    }
    
    public Menu(String newSerializedLibrary) {
    	userSays = new Scanner(System.in);
        books = FileHelper.read(newSerializedLibrary);
    }
    
    /**
     *The menu loop starts running
     */
    public void theShowMustGoOn(){
        char select = ' ';
        String selection;
        
        while(select != 'E'){
            printMenu();
            selection = userSays.nextLine();
            if(!selection.isEmpty()) select = selection.toUpperCase().charAt(0);
            
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
        ArrayList<Book> listOfBooks = null;
        
        Search find = new Search(books);
        //char c = find.promptUser();
        listOfBooks = find.search(books); 
        if(listOfBooks != null) System.out.print(booksToTable(listOfBooks));
        
    }
    private void addBook() {
        String isbn, title;
        int edition;
        double price;
        List<Author> authors = new ArrayList<>();
        
        System.out.println("ISBN:");
        isbn = userSays.nextLine();
        System.out.println("Title:");
        title = userSays.nextLine();
        System.out.println("Edition:");
        edition = Integer.parseInt(userSays.nextLine());
        System.out.println("Price:");
        price = Double.parseDouble(userSays.nextLine());
        int authorCount = 0;
        while (true)
        {
            authorCount++;
            System.out.println("(q for quit) Author " + authorCount + ":");
            String name = userSays.nextLine();
            if (name.equals("q")) break;
            authors.add(new Author(name));
        }
        Book book = new Book(isbn, title, edition, price);
        for (Author a : authors)
            book.addAuthor(a);
        books.addBook(book);
    }

    private void removeBook(CollectionOfBooks books) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    private void showLibrary(CollectionOfBooks books) {
            System.out.print("--\t--Library--\t--\n");
            for(Book.BookValue v: BookValue.values()){
                System.out.print(v + "\t");
                if(v.equals(Book.BookValue.Title)) System.out.print("\t");
            }
            for(Book b: books.getBooks()){
                System.out.println("");
                int i = 0;
                for(String s: b.toString().split(";")){
                    System.out.print(s + "\t");
                    if(i == 1 && s.length() < 15) System.out.print("\t");
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