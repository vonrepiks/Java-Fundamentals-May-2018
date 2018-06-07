import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] stonesArray = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);

        Deque<Integer> stones = new ArrayDeque<>();
        int gold = 0;

        Collections.addAll(stones, stonesArray);

        String line;
        while (true) {
            if ("Revision".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String command = tokens[0] + " " + tokens[1];
            int n = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Apply acid":
                    if (stones.isEmpty()) {
                        continue;
                    }

                    while (n-- > 0) {
                        int stone = stones.removeFirst();

                        stone -= 1;

                        if (stone == 0) {
                            gold++;
                        } else {
                            stones.add(stone);
                        }

                        if (stones.isEmpty()) {
                            break;
                        }
                    }
                    break;
                case "Air leak":
                    if (gold == 0) {
                        continue;
                    }
                    stones.add(n);
                    gold--;
                    break;
            }
        }

        System.out.println(String.join(" ", stones.stream().map(String::valueOf).collect(Collectors.toList())));
        System.out.println(gold);
    }
}
