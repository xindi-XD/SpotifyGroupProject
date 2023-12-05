package use_case.get_song_stats;

public class GetStatsInputData {
    final private String id;

    public GetStatsInputData(String id) {
        this.id = id;
    }

    public String getId() {return id;}
}
