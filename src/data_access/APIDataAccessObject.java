package data_access;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.get_song_stats.GetStatsAPIDataAccessInterface;
import use_case.search.SearchAPIDataAccessInterface;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

public class APIDataAccessObject implements SearchAPIDataAccessInterface, GetStatsAPIDataAccessInterface {
    private static final String CLIENT_ID = System.getenv("CLIENT_ID");
    private static final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");

    private static String getClientCredentials() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create("grant_type=client_credentials", mediaType);
        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .method("POST", body)
                .addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((CLIENT_ID +
                        ":" + CLIENT_SECRET).getBytes()))
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            if (response.code() == 200) {
                JSONObject responseBody = new JSONObject(response.body().string());
                System.out.println(responseBody.getInt("expires_in"));
                return responseBody.getString("access_token");
            }
            else {
                System.out.println("Error response code: " + response.code());
                System.out.println("Error response body: " + response.body().string());

                throw new RuntimeException("Response not successful. See console for details.");
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray search(String query, String type) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/search?q=" + query + "&type=" + type)
                .method("GET", null)
                .addHeader("Authorization", "Bearer " + getClientCredentials())
                .build();
        return getObjects(type, client, request);
    }

    public JSONArray search(String query, String type, int limit) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/search?q=" + query + "&type=" + type + "&limit=" + limit)
                .method("GET", null)
                .addHeader("Authorization", "Bearer " + getClientCredentials())
                .build();
        return getObjects(type, client, request);
    }

    private JSONArray getObjects(String type, OkHttpClient client, Request request) {
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            if (response.code() == 200) {
                JSONObject responseBody = new JSONObject(response.body().string());
                return responseBody.getJSONObject(type + "s").getJSONArray("items");
            }
            else {
                System.out.println("Error response code: " + response.code());
                System.out.println("Error response body: " + response.body().string());

                throw new RuntimeException("Response not successful. See console for details.");
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getTrack(String id) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/tracks/" + id)
                .method("GET", null)
                .addHeader("Authorization", "Bearer " + getClientCredentials())
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            if (response.code() == 200) {
                return new JSONObject(response.body().string());
            } else {
                System.out.println("Error response code: " + response.code());
                System.out.println("Error response body: " + response.body().string());

                throw new RuntimeException("Response not successful. See console for details.");
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Float> getTrackFeatures(String id) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/audio-features/" + id)
                .method("GET", null)
                .addHeader("Authorization", "Bearer " + getClientCredentials())
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            if (response.code() == 200) {
                JSONObject results = new JSONObject(response.body().string());
                HashMap<String, Float> features = new HashMap<>();
                String[] featureNames = {"acousticness", "danceability", "energy", "instrumentalness", "liveness",
                        "loudness", "speechiness", "valence"};
                for (String feature : featureNames) {
                    features.put(feature, results.getFloat(feature));
                }
                return features;
            } else {
                System.out.println("Error response code: " + response.code());
                System.out.println("Error response body: " + response.body().string());

                throw new RuntimeException("Response not successful. See console for details.");
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
