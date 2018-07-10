package tests;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        User user = new User("Pesho");
        User user1 = new User("Ivan");
        ;


        user.compareTo(user1);

        Function<Integer, String> function = (x) -> {
            return String.valueOf(x);
        };

        System.out.println(function.apply(3));


    }
}
