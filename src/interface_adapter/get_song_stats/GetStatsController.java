package interface_adapter.get_song_stats;

import use_case.get_song_stats.GetStatsInputBoundary;
import use_case.get_song_stats.GetStatsInputData;

public class GetStatsController {
    final GetStatsInputBoundary getStatsInteractor;

    public GetStatsController(GetStatsInputBoundary interactor) {
        this.getStatsInteractor = interactor;
    }

    public void execute(String id) {
        GetStatsInputData getStatsInputData = new GetStatsInputData(id);
        getStatsInteractor.execute(getStatsInputData);
    }
}
