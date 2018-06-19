package online_radio;

import online_radio.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfSongs = Integer.parseInt(reader.readLine());

        RadioDatabase radioDatabase = new RadioDatabase();

        while (countOfSongs-- > 0) {
            String[] songTokens = reader.readLine().split(";");

            try {
                Song song = new Song(songTokens[0], songTokens[1]);

                SongLength songLength = new SongLength(songTokens[2]);

                song.setSongLength(songLength);

                radioDatabase.addSong(song);

                System.out.println("Song added.");

            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.println(String.format("Songs added: %d", radioDatabase.getSongs().size()));
        System.out.println(radioDatabase.getPlaylistLength());
    }
}
