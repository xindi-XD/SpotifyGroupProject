package data_access;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

//should I move this to SongOrganizer.java ?
public class APIDataAccessObject {
    private static final String API_URL = "https://api.spotify.com/v1";
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public String createPlaylist(String userid) {
        //TODO: possibly an option to save this new playlist to an internal file?
        //creates a playlist under this userid
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("A PlayList", false); // false means it's a private playlist.
        RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
        Request request = new Request.Builder()
                .url(String.format("https://api.spotify.com/v1/users/%s/playlists", userid))
                .method("PUT", body)
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            return responseBody.getString("name");
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMe() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me")
                .addHeader("Authorization", "Bearer " + API_TOKEN)
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            return responseBody.getString("display_name");
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
