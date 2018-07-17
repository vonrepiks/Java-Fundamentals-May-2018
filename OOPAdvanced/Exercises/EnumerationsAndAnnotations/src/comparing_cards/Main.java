package comparing_cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank1 = reader.readLine();
        String suit1 = reader.readLine();
        String rank2 = reader.readLine();
        String suit2 = reader.readLine();

        try {
            Card card1 = new Card(rank1, suit1);
            Card card2 = new Card(rank2, suit2);

            String output = card1.compareTo(card2) > 0 ?
                    String.format("Card name: %s; Card power: %d",
                            card1,
                            card1.getPower()) :
                    String.format("Card name: %s; Card power: %d",
                            card2,
                            card2.getPower());

//            String output1;
//
//            if (card1.compareTo(card2) > 0) {
//                output1 = String.format("Card name: %s; Card power: %d",
//                        card1,
//                        card1.getPower());
//            } else {
//                output1 = String.format("Card name: %s; Card power: %d",
//                        card2,
//                        card2.getPower());
//            }

            System.out.println(output);
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }
}
