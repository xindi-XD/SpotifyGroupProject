package use_case.add_song;

import entity.*;
import org.json.JSONObject;
import use_case.get_song_stats.GetStatsAPIDataAccessInterface;
import use_case.get_song_stats.GetStatsInputData;
import use_case.get_song_stats.GetStatsOutputBoundary;
import use_case.get_song_stats.GetStatsOutputData;

import java.util.HashMap;

public class AddSongInteractor implements AddSongInputBoundary{
    final AddSongDataAccessInterface getSongDataAccessInterface;
    final AddSongOutputBoundary addSongPresenter;

    public AddSongInteractor(AddSongDataAccessInterface getSongDataAccessInterface,
                             AddSongOutputBoundary addSongOutPutBoundary) {
        this.getSongDataAccessInterface = getSongDataAccessInterface;
        this.addSongPresenter = addSongOutPutBoundary;
    }


    public void execute(AddSongInputData addSongInputData) {
        if (addSongInputData.getSongId().isEmpty()) {
            addSongPresenter.prepareFailView("Song doesn't exist");
        }
        else {
            String songId = addSongInputData.getSongId();
            CommonSong result = CommonSongFactory.create(songId);
            Playlist playlist = getSongDataAccessInterface.getPlaylists().get(addSongInputData.getSelectedPlaylist());
            playlist.addSong(result);
            addSongPresenter.prepareSuccessView();
        }
    }
}
