package cl.javdev.examples;

import cl.javdev.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class E1DeserializeMain {

    public static void main(String[] args) throws IOException {
        // creating file for save info
        Person sam = Person.newBuilder()
                .setAge(10)
                .setName("sam")
                .build();

        Path path = Paths.get("sam.ser");
        Files.write(path,sam.toByteArray());

        // read file
        byte[] bytesSam = Files.readAllBytes(path);
        Person newSam = Person.parseFrom(bytesSam);
        System.out.println(newSam);
    }
}
