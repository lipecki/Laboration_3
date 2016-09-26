/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Viggo
 */
public class FileHelper {
    
    public static void newFile() throws IOException
    {
        File file = new File("books");
        file.delete();
        file.createNewFile();
        
    }
    
    public static void deleteFile()
    {
        File file = new File("books");
        file.delete();
    }
    
    public static void write(CollectionOfBooks coll)
    {
        try {
            File file = new File("books");
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream obout = new ObjectOutputStream(out);
            obout.writeObject(coll);
        }
        catch (FileNotFoundException fnfex)
        {
            System.out.println("Could not find the file containing books!");
            System.out.print(fnfex.getMessage());
            System.out.println("");
        }
        catch (IOException ioex)
        {
            System.out.println("Could not write to the file, please make sure that it's not already in use by another process.");
            System.out.print(ioex.getMessage());
            System.out.println("");
        }
    }
    
    public static CollectionOfBooks read()
    {
       CollectionOfBooks coll = new CollectionOfBooks();
       try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("books"));
            coll = (CollectionOfBooks) in.readObject();
       }
       catch (FileNotFoundException fnfex)
       {
            System.out.println("Could not find the file containing books!");
            System.out.print(fnfex.getMessage());
            System.out.println("");
       }
       catch (IOException ioex)
       {
            System.out.println("Could not read from the file, please make sure that it's not already in use by another process.");
            System.out.print(ioex.getMessage());
            System.out.println("");
       }
       catch (ClassNotFoundException cnfex)
       {
           System.out.println("Failed to deserialize object");
           System.out.print(cnfex.getMessage());
           System.out.println("");
       }
       
    }
}
