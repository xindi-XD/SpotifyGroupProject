package use_case.add_song;

import java.util.HashMap;
import java.util.Objects;

public class AddSongInputData {

    final private String songId;
    final private String selectedPlaylist;

    public AddSongInputData(String songId, String selectedPlaylist) {
        this.songId = songId;
        this.selectedPlaylist = selectedPlaylist;
    }

    public String getSongId() {return this.songId;}

    public String getSelectedPlaylist() {return this.selectedPlaylist;}

}
