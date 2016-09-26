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
 * A toolkit for creating, deleting, reading and writing CollectionOfBooks objects to a file
 * @author Viggo Lundén <vlunden@kth.se>
 */
public class FileHelper {
    /**
     * Creates a new file
     * @param filename the path and name of the file
     */
    public static void newFile(String filename)
    {
            
        try {
            File file = new File(filename);
            file.delete();
            file.createNewFile();
        } catch (IOException iOException) {
            System.out.println("Failed to create new file.");
            System.out.print(iOException.getMessage());
            System.out.println("");
        }
        
        
    }
    
    /**
     * Deletes a file
     * @param filename The path and name of the file to delete
     */
    public static void deleteFile(String filename)
    {
        File file = new File(filename);
        file.delete();
    }
    
    /**
     * Writes a CollectionOfBooks object to a file
     * @param coll CollectionOfBooks to be written
     * @param filename The path and name of the file
     */
    public static void write(CollectionOfBooks coll, String filename)
    {
        try {
            File file = new File(filename);
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
    /**
     * Reads a CollectionOfBooks from a file
     * @param filename the path and name of the file to read
     * @return the CollectionOfBooks. Null if the file is empty.
     */
    public static CollectionOfBooks read(String filename)
    {
       CollectionOfBooks coll = new CollectionOfBooks();
       try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
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
       finally {
           return coll;
       }
    }
}
