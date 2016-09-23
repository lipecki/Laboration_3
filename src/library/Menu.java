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
import java.util.Scanner;

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
    public void theShowMustGoOn(){
        char select = ' ';
        String selection;
        
        while(select != 'Q'){
            printMenu();
            selection = userSays.nextLine();
            select = selection.toUpperCase().charAt(0);
            
            switch(select) {
                case 'A':   addBook(); break;
                case 'R':   removeBook(); break;
                case 'S':   retrieveQuery(); break;
                case 'L':   showLibrary(); break;
                case 'E':   System.out.println("End of line"); for(int i = 0; i < 30; i++) System.out.println(""); break;
                default:    System.out.println("Sorry, I must have misread. Please select again!");
            }
            
        }
    }

    private static void printMenu(){
        String [] menu = {""
                + "------Menu------",""
                + "A: Add Book",""
                + "R: Remove Book",""
                + "S: Search",""
                + "L: Show Library",""
                + "E: End Of Line"};
        for(String s: menu) System.out.println(s);
    }
    
    private static void printSearchMenu(){
        String [] menu = {""
                + "--\t--Search Menu--\t--",""
                + "T: Title search"
                + "I: ISBN search"
                + "A: Author search"
                + "N: Nevermind, Please take me back!"};
        for(String s: menu) System.out.println("\t" + s);
    }

    private void retrieveQuery() {
        char select = ' ';
        String selection;
        ArrayList<Book> books = new ArrayList();
        
        while(select != 'N'){
            printSearchMenu();
            selection = userSays.nextLine();
            select = selection.toUpperCase().charAt(0);
            
            switch(select) {
                case 'T':   titleSearch(); break;
                case 'I':   isbnSearch(); break;
                case 'A':   authorSearch(); break;
                case 'N':   break;
                default:    System.out.println("Sorry, I must have misread. Please select again!");
            }
        }
    }

    private void addBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void removeBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showLibrary() {
        String[] library = {
            "--\t--Library--\t--\n",
            "Author\t",
            "Title\t",
            "Edition\t",
            "Price\t",
            "ISBM\t"
        };
        for (String s : library)
        {
            System.out.print(s);
        }
        
        
    }

    private void titleSearch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void isbnSearch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void authorSearch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
