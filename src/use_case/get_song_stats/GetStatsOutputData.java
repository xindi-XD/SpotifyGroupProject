package use_case.get_song_stats;

import entity.CommonSong;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class GetStatsOutputData {
    private ArrayList<String> playlistnames;
    private final CommonSong result;

    private final HashMap<String, Float> features;
    private boolean useCaseFailed;

    public GetStatsOutputData(ArrayList<String> playlistnames, CommonSong result, HashMap<String, Float> resultFeatures,
                              boolean failed) {
        this.playlistnames = playlistnames;
        this.result = result;
        this.features = resultFeatures;
        this.useCaseFailed = failed;

    }


    public HashMap<String, Float> getFeatures() {return this.features;}
    public String getId() {return result.getId();}

    public String getName() {return result.getName();}

    public String getArtists() {return result.getArtistName();}

    public String getReleaseDate() {return result.getReleaseDate();}


    public ArrayList<String> getPlaylistnames() {return this.playlistnames;}

}
