package online_radio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadioDatabase {

    private List<Song> songs;

    public RadioDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(this.songs);
    }

    public String getPlaylistLength() {
        int allMinutes = this.songs.stream().mapToInt(x -> x.getSongLength().getMinutes()).sum();
        int allSeconds = this.songs.stream().mapToInt(x -> x.getSongLength().getSeconds()).sum();
        allSeconds += allMinutes * 60;

        int hours = allSeconds / 3600;
        int minutes = (allSeconds % 3600) / 60;
        int seconds = (allSeconds % 60);

        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }
}

