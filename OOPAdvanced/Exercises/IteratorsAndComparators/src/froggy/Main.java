package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers =
                Stream.of(reader.readLine().split(" |, "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        Lake<Integer> lake = new Lake<>(numbers);

        List<Integer> result = new ArrayList<>();
        lake.forEach(number -> result.add(number));

        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
