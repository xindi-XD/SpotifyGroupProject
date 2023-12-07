package interface_adapter.add_song;

import use_case.add_song.AddSongInputBoundary;
import use_case.add_song.AddSongInputData;
import use_case.delete_playlist.DeletePlaylistInputBoundary;
import use_case.delete_playlist.DeletePlaylistInputData;
import use_case.get_song_stats.GetStatsInputData;

import java.util.HashMap;

public class AddSongController {
    final AddSongInputBoundary addSongInteractor;

    public AddSongController(AddSongInputBoundary addSongInteractor) {
        this.addSongInteractor = addSongInteractor;
    }


    public void execute(String songId, String selectedPlaylist) {
        AddSongInputData addSongInputData = new AddSongInputData(songId, selectedPlaylist);
        addSongInteractor.execute(addSongInputData);
    }
}
