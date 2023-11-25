package use_case.search;

import org.json.JSONArray;

public interface SearchPlaylistDataAccessInterface {
    JSONArray searchTrack(String query);
}
