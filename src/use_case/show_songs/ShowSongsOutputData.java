package use_case.show_songs;

import java.util.Map;

public class ShowSongsOutputData {
    private final Map<String, String[]> songs;
    public ShowSongsOutputData(Map<String, String[]> songs) {
        this.songs = songs;
    }

    public Map<String, String[]> getSongs() {
        return songs;
    }
}
