import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HighScores {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Pair<String, Long>>> duels = new LinkedHashMap<>();
        while (true){
            String line = reader.readLine();
            if (line.equals("osu!")){
                break;
            }

            String[] tokens = line.split("[\\s<>-]+");

            String firstPlayerName = tokens[1];
            String secondPlayerName = tokens[2];
            long firstPlayerScore = Long.parseLong(tokens[0]);
            long secondPlayerScore = Long.parseLong(tokens[3]);

            if (!duels.containsKey(firstPlayerName)){
                duels.put(firstPlayerName, new ArrayList<>());
            }
            if (!duels.containsKey(secondPlayerName)){
                duels.put(secondPlayerName, new ArrayList<>());
            }

            Pair<String, Long> firstPlayer = new Pair<>(firstPlayerName, secondPlayerScore - firstPlayerScore);
            Pair<String, Long> secondPlayer = new Pair<>(secondPlayerName, firstPlayerScore - secondPlayerScore);

            duels.get(firstPlayerName).add(secondPlayer);
            duels.get(secondPlayerName).add(firstPlayer);
        }

//        duels.entrySet()
//                .stream()
//                .sorted((firstPlayer, secondPlayer) -> {
//                    long firstPlayerScore = firstPlayer.getValue().stream().mapToLong(p -> p.getValue()).sum();
//                    long secondPlayerScore = secondPlayer.getValue().stream().mapToLong(Pair::getValue).sum();
//                    return Long.compare(secondPlayerScore, firstPlayerScore);
//                })
//                .forEach(player -> {
//                    long playerScore = player.getValue().stream().mapToLong(Pair::getValue).sum();
//                    System.out.println(String.format("%s - (%d)", player.getKey(), playerScore));
//                    List<Pair<String, Long>> list = player.getValue();
//                    list.stream()
//                            .sorted((first, second) -> {
//                                int comp1 = first.getKey().compareTo(second.getKey());
//
//                                if (comp1 != 0) {
//                                    return comp1;
//                                }
//
//                                return Long.compare(second.getValue(), first.getValue());
//                            })
//                            .forEach(pair -> {
//                                System.out.println(String.format("*   %s <-> %d", pair.getKey(), pair.getValue()));
//                            });
//                });

        duels.entrySet()
                .stream()
                .sorted((firstPlayer, secondPlayer) -> {
                    long firstPlayerScore = firstPlayer.getValue().stream().mapToLong(p -> p.getValue()).sum();
                    long secondPlayerScore = secondPlayer.getValue().stream().mapToLong(Pair::getValue).sum();
                    return Long.compare(secondPlayerScore, firstPlayerScore);
                })
                .forEach(player -> {
                    long playerScore = player.getValue().stream().mapToLong(Pair::getValue).sum();
                    System.out.println(String.format("%s - (%d)", player.getKey(), playerScore));
                    List<Pair<String, Long>> list = player.getValue();
                    list.stream()
                            .sorted(Comparator.comparing((Pair<String, Long>p) -> p.getKey()).thenComparing(Pair::getValue, Comparator.reverseOrder()))
                            .forEach(pair -> {
                                System.out.println(String.format("*   %s <-> %d", pair.getKey(), pair.getValue()));
                            });
                });
    }
}
