import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        int maxScore = Integer.MIN_VALUE;
        String winner = "";
        for (int i = 0; i < count; i++) {
            String name = reader.readLine();
            int score = Integer.parseInt(reader.readLine());

            char[] letters = name.toCharArray();

            for (char letter : letters) {
                if (letter % 2 == 0) {
                    score += letter;
                } else {
                    score -= letter;
                }
            }

            if(maxScore < score){
                maxScore = score;
                winner = name;
            }
        }

        if(maxScore != 0){
            System.out.println(String.format("The winner is %s - %s points", winner, maxScore));
        }
    }
}
