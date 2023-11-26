package use_case.search;

import org.json.JSONArray;

public interface SearchAPIDataAccessInterface {
    JSONArray searchTrack(String query);
}
