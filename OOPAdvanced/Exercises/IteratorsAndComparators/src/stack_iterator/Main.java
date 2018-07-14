package stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyStack<Integer> myStack = new MyStack<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = Arrays.stream(line.split("\\s+"))
                    .map(e -> e.replace(",", ""))
                    .toArray(String[]::new);

            switch (tokens[0]) {
                case "Push":
                    int[] numbers = Arrays.stream(tokens)
                            .skip(1)
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    for (int number : numbers) {
                        myStack.push(number);
                    }
                    break;
                case "Pop":
                    try {
                        myStack.pop();
                    } catch (NoSuchElementException nsee) {
                        System.out.println(nsee.getMessage());
                    }
                    break;
            }
        }

        printElements(myStack);
        printElements(myStack);
    }

    private static void printElements(MyStack<Integer> myStack) {
        for (Integer integer : myStack) {
            System.out.println(integer);
        }
    }
}
