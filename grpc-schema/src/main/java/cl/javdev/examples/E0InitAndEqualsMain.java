package cl.javdev.examples;

import cl.javdev.models.Person;

public class E0InitAndEqualsMain {
    //initAndEquals
    public static void main(String[] args) {

        Person sam = Person.newBuilder()
                .setAge(10)
                .setName("sam")
                .build();

        Person Sam = Person.newBuilder()
                .setAge(20)
                .setName("Sam")
                .build();
        System.out.println(sam.equals(Sam));
    }
}
