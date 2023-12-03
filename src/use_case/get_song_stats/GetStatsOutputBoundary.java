package use_case.get_song_stats;

public interface GetStatsOutputBoundary {
    void prepareFailView(String e);

    void prepareSuccessView(GetStatsOutputData getStatsOutputData);
}
