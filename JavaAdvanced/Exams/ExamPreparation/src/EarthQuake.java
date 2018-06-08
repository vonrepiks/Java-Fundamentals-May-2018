import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class EarthQuake {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        List<List<Integer>> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> seq = new ArrayList<>();

            String[] str = reader.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                seq.add(Integer.valueOf(str[j]));
            }


            sequence.add(seq);
        }

        int count = 0;

        while (true) {

            boolean isItElements = false;

            for (List<Integer> integers : sequence) {

                if (integers.size() > 0) {
                    count = 0;
                    int num = integers.get(0);
                    deque.add(integers.get(count));
                    integers.remove(count);
                    int p = integers.size();
                    for (int i = 0; i < p; i++) {
                        if (num >= integers.get(0)) {
                            integers.remove(0);
                        } else {
                            break;
                        }
                    }

                    isItElements = true;
                }
            }
            if (!isItElements) {
                break;
            }
        }

        int c = deque.size();

        System.out.println(c);

        for (int i = 0; i < c; i++) {

            System.out.print(deque.poll() + " ");
        }
    }
}