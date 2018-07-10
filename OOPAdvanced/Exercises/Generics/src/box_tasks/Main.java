package box_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfBoxes = Integer.parseInt(reader.readLine());

        // Problem 1.	Generic Box
//        List<Box<String>> boxes = new ArrayList<>();
//
//        while (countOfBoxes-- > 0) {
//            String input = reader.readLine();
//
//            Box<String> box = new Box<>();
//            box.setValue(input);
//
//            boxes.add(box);
//        }
//
//        boxes.forEach(System.out::println);

        // Problem 2.	Generic Box of Integer
//        List<Box<Integer>> boxes = new ArrayList<>();
//
//        while (countOfBoxes-- > 0) {
//            int input = Integer.parseInt(reader.readLine());
//
//            Box<Integer> box = new Box<>();
//            box.setValue(input);
//
//            boxes.add(box);
//        }
//
//        boxes.forEach(System.out::println);

        // Problem 3.	Generic Swap Method Strings
//        List<Box<String>> boxes = new ArrayList<>();
//
//        while (countOfBoxes-- > 0) {
//            String input = reader.readLine();
//
//            Box<String> box = new Box<>();
//            box.setValue(input);
//
//            boxes.add(box);
//        }
//
//        int[] indexes = Stream.of(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//        swap(boxes, indexes[0], indexes[1]);
//
//        boxes.forEach(System.out::println);

        // Problem 4.	Generic Swap Method Integers
//        List<Box<Integer>> boxes = new ArrayList<>();
//
//        while (countOfBoxes-- > 0) {
//            int input = Integer.parseInt(reader.readLine());
//
//            Box<Integer> box = new Box<>();
//            box.setValue(input);
//
//            boxes.add(box);
//        }
//
//        int[] indexes = Stream.of(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//        swap(boxes, indexes[0], indexes[1]);
//
//        boxes.forEach(System.out::println);

        // Problem 5.	Generic Count Method Strings
//        List<ComparableBox<String>> boxes = new ArrayList<>();
//
//        while (countOfBoxes-- > 0) {
//            String input = reader.readLine();
//
//            ComparableBox<String> box = new ComparableBox<>();
//            box.setValue(input);
//
//            boxes.add(box);
//        }
//
//        ComparableBox<String> box = new ComparableBox<>();
//        box.setValue(reader.readLine());
//
//        System.out.println(getCountOfGreaterElements(boxes, box));

        // Problem 6.	Generic Count Method Doubles
        List<ComparableBox<Double>> boxes = new ArrayList<>();

        while (countOfBoxes-- > 0) {
            Double input = Double.valueOf(reader.readLine());

            ComparableBox<Double> box = new ComparableBox<>();
            box.setValue(input);

            boxes.add(box);
        }

        ComparableBox<Double> box = new ComparableBox<>();
        box.setValue(Double.valueOf(reader.readLine()));

        System.out.println(getCountOfGreaterElements(boxes, box));
    }

    private static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex) {
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }

    private static <T extends Comparable<T>> int getCountOfGreaterElements(List<ComparableBox<T>> elements, ComparableBox<T> singleElement) {
        return elements.stream()
                .filter(element -> element.compareTo(singleElement) > 0)
                .collect(Collectors.toList())
                .size();
    }
}
