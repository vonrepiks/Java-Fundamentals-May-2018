import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddAndEvenPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] sequence = reader.readLine().split("\\s+");

        if (sequence.length % 2 != 0) {
            System.out.println("invalid length");
        } else {
            String result;
            for (int i = 0; i < sequence.length; i += 2) {
                int first = Integer.parseInt(sequence[i]);
                int second = Integer.parseInt(sequence[i + 1]);

                if (first % 2 == 0 && second % 2 == 0) {
                    result = String.format("%d, %d -> both are even", first, second);
                } else if (first % 2 != 0 && second % 2 != 0) {
                    result = String.format("%d, %d -> both are odd", first, second);
                } else {
                    result = String.format("%d, %d -> different", first, second);
                }
                System.out.println(result);
            }
        }
    }
}