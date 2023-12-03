import entity.CommonSong;
import entity.CommonSongFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import data_access.APIDataAccessObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TestAPI {
    @Test
    public void testSearchTrack() {
        APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
        JSONArray searchTrackResults = apiDataAccessObject.search("abc", "track");
        assert searchTrackResults.length() == 20;
        searchTrackResults = apiDataAccessObject.search("abc", "track", 10);
        assert searchTrackResults.length() == 10;
        ArrayList<CommonSong> returnedSongs = new ArrayList<>();
        for (int i = 0; i < searchTrackResults.length(); i++) {
            returnedSongs.add(CommonSongFactory.create(searchTrackResults.getJSONObject(i)));
            assert !returnedSongs.get(i).getID().isEmpty();
            System.out.println(returnedSongs.get(i).getName());
        }
    }

    @Test
    public void testGetTrack() {
        APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
        JSONObject songResult = apiDataAccessObject.getTrack("6kyHcHEBPtwjEbUWrNuLlv");
        CommonSong song = CommonSongFactory.create(songResult);
        assert song.getName().equals("Among Us (Trap Remix)");
        assert song.getID().equals("6kyHcHEBPtwjEbUWrNuLlv");
        assert song.getArtist().length == 1;
        assert song.getArtist()[0].equals("Leonz");
    }

    @Test
    public void testGetFeatures() {
        APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
        HashMap<String, Float> result = apiDataAccessObject.getTrackFeatures("6kyHcHEBPtwjEbUWrNuLlv");
        String[] featureNames = {"acousticness", "danceability", "energy", "instrumentalness", "liveness",
                "loudness", "speechiness", "valence"};
        for (String feature : featureNames) {
            assert result.get(feature) != null;
            System.out.println(result.get(feature));
        }
    }

}
