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
    
    public static void deleteFile() throws IOException
    {
        File file = new File("books");
        file.delete();
    }
    
    public static void write(CollectionOfBooks coll) throws FileNotFoundException, IOException
    {
        File file = new File("books");
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream obout = new ObjectOutputStream(out);
        obout.writeObject(coll);
    }
    
    public static CollectionOfBooks read() throws IOException, ClassNotFoundException
    {
       CollectionOfBooks coll;
       ObjectInputStream in = new ObjectInputStream(new FileInputStream("books"));
       coll = (CollectionOfBooks) in.readObject();
       return coll;
    }
}
