import java.util.function.*;

public class Demo {
    public static void main(String[] args) {
        // consumer("name");

        Consumer<String> real = (name) -> {
            System.out.println("I'm real consumer" + name);
        };

        Supplier<Integer> realSupplier = () -> {
            return 10;
        };
        // Supplier<Integer> realSupplierJustLambda = () -> 10;

        Predicate<Integer> predicate = (a) -> {
            return a > 5;
        };

        // Predicate<Integer> predicateJustLambda = (a) -> a > 5;

//        Function<Integer[], Integer> function = (numbers) -> {
////            return numbers.length;
////        };
        Function<Integer[], Integer> functionJustLambda = (numbers) -> numbers.length;

        BiFunction<Integer, Integer, Long> biFunction = (first, second) -> {
            return Long.valueOf(first + second);
        };


        // real.accept("name");
        // System.out.println(realSupplier.get());
        // System.out.println(predicate.test(6));
        // System.out.println(functionJustLambda.apply(new Integer[]{1, 2, 3}));
        System.out.println(biFunction.apply(10, 5));
    }

    private static void consumer(String name) {
        System.out.println("I'm a consumer!" + name);
    }

    private static int supplier() {
        return 10;
    }

    private static boolean predicate() {
        return 3 > 5;
    }

    private static int lengthOfArray(int[] numbers) {
        return numbers.length;
    }

    private static Integer sum(int first, int second) {
        return first + second;
    }
}
