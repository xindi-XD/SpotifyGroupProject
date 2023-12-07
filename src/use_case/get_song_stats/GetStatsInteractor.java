package use_case.get_song_stats;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonSong;
import entity.CommonSongFactory;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class GetStatsInteractor implements GetStatsInputBoundary{
    final GetStatsAPIDataAccessInterface getStatsAPIDataAccessObject;
    final GetStatsOutputBoundary getStatsPresenter;

    final GetStatsFilePlaylistDataAccessInterface getStatsFilePlaylistDataAccessObject;

    public GetStatsInteractor(GetStatsAPIDataAccessInterface getStatsAPIDataAccessInterface,
                              GetStatsOutputBoundary getStatsOutputBoundary, GetStatsFilePlaylistDataAccessInterface getStatsFilePlaylistDataAccessObject) {
        this.getStatsAPIDataAccessObject = getStatsAPIDataAccessInterface;
        this.getStatsPresenter = getStatsOutputBoundary;
        this.getStatsFilePlaylistDataAccessObject = getStatsFilePlaylistDataAccessObject;
    }

    @Override
    public void execute(GetStatsInputData getStatsInputData) {
        if (getStatsInputData.getId().isEmpty()) {
            getStatsPresenter.prepareFailView("Song doesn't exist");
        }
        else {
            String songId = getStatsInputData.getId();
            CommonSong result = CommonSongFactory.create(songId);
            //JSONObject result = getStatsAPIDataAccessObject.getTrack(songId);
            HashMap<String, Float> resultFeatures = getStatsAPIDataAccessObject.getTrackFeatures(songId);
            ArrayList<String> playlistnames = getStatsFilePlaylistDataAccessObject.playlistnames();
            GetStatsOutputData getStatsOutputData = new GetStatsOutputData(playlistnames, result, resultFeatures, false);
            getStatsPresenter.prepareSuccessView(getStatsOutputData);
        }
    }
}
