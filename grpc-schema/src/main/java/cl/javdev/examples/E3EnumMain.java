package cl.javdev.examples;

import cl.javdev.models.Cheese;
import cl.javdev.models.TypeCheese;

public class E3EnumMain {
    public static void main(String[] args) {
        Cheese cheese = Cheese.newBuilder().setName("cheese1").setTypeCheese(TypeCheese.BLUE).build();
        System.out.println(cheese);
    }
}
