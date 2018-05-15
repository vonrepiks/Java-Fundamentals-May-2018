import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitTheTarget {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int sum;
        int subtract;

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                subtract = i - j;
                sum = i + j;
                if(sum == n){
                    System.out.println(String.format("%s + %s = %s", i, j, n));
                }
                if(subtract == n){
                    System.out.println(String.format("%s - %s = %s", i, j, n));
                }
            }
        }
    }
}
