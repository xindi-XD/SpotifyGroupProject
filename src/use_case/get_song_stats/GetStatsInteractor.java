package use_case.get_song_stats;

import org.json.JSONObject;

import java.util.HashMap;

public class GetStatsInteractor implements GetStatsInputBoundary{
    final GetStatsAPIDataAccessInterface getStatsAPIDataAccessObject;
    final GetStatsOutputBoundary getStatsPresenter;

    public GetStatsInteractor(GetStatsAPIDataAccessInterface getStatsAPIDataAccessInterface,
                              GetStatsOutputBoundary getStatsOutputBoundary) {
        this.getStatsAPIDataAccessObject = getStatsAPIDataAccessInterface;
        this.getStatsPresenter = getStatsOutputBoundary;
    }

    @Override
    public void execute(GetStatsInputData getStatsInputData) {
        if (getStatsInputData.getId().isEmpty()) {
            getStatsPresenter.prepareFailView("Song doesn't exist");
        }
        else {
            String songId = getStatsInputData.getId();
            JSONObject result = getStatsAPIDataAccessObject.getTrack(songId);
            HashMap<String, Float> resultFeatures = getStatsAPIDataAccessObject.getTrackFeatures(songId);
            GetStatsOutputData getStatsOutputData = new GetStatsOutputData(result, resultFeatures, false);
            getStatsPresenter.prepareSuccessView(getStatsOutputData);
        }
    }
}
