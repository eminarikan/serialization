package dev.eminarikan;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        serializeThem();
    }

    public static void keepThemInMemory(){
        Instant start = Instant.now();
        ArrayList<Cat> cats = new ArrayList<Cat>();
        for(int i = 0; i < 1_000_000_000L; i++){
            Cat c = new Cat("asdasdasasdad", 12312);
            cats.add(c);
        }        
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(timeElapsed);
    }

    public static void serializeThem() throws FileNotFoundException, IOException{
        Instant start = Instant.now();
        for(int i = 0; i < 20000; i++){
            Cat c = new Cat("asdasdasasdad", 12312);
            SerializationHelper.serialize(c);
        }         
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(timeElapsed);
    }

}
