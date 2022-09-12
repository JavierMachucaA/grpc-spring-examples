package cl.javdev.examples;

import cl.javdev.models.Book;
import cl.javdev.models.Library;
import cl.javdev.models.Registry;
import cl.javdev.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E2CollectionMain {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(Book.newBuilder().setSerial(1).setTitle("harry potter").build());
        list.add(Book.newBuilder().setSerial(2).setTitle("harry potter 2").build());
        list.add(Book.newBuilder().setSerial(3).setTitle("harry potter 3").build());
        Library library = Library.newBuilder()
                .addAllBookList(list).build();
        System.out.println(library);

        Map<Integer, User> mapUsersRegistry = new HashMap<>();
        mapUsersRegistry.put(1, User.newBuilder().setName("Javier").setRut(1).build());
        mapUsersRegistry.put(2, User.newBuilder().setName("Fena").setRut(2).build());

        Registry registry = Registry.newBuilder().putAllUser(mapUsersRegistry).build();

        System.out.println(registry);
    }
}
