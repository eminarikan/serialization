package dev.eminarikan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationHelper {
    
    private static final String tempFolder = "C:\\Workspace\\temp";

    
    public static String serialize(Object object) throws FileNotFoundException, IOException{
        
        File tempFile = File.createTempFile("obj", "", new File(tempFolder));
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempFile))){
            oos.writeObject(object);
            oos.flush();
        }
        
        return tempFile.getAbsolutePath();
    }

    public static Object deserialize(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
        Object object = null;
        File file = new File(filename);
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            object = ois.readObject();
        }
        file.delete();
        return object;
    }
}
