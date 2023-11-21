package data_access;

import entity.Song;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

public class APIDataAccessObject {
    private static final String CLIENT_ID = System.getenv("CLIENT_ID");
    private static final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");

    public static String getApiToken() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create("grant_type=client_credentials", mediaType);
        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .method("POST", body)
                .addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes()))
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            if (response.code() == 200) {
                JSONObject responseBody = new JSONObject(response.body().string());
                return responseBody.getString("access_token");
            }
            else {
                throw new RuntimeException("Response not successful");
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Song> searchTrack(String query) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/search?q=%track:" + query)
                .addHeader("Authorization", "Bearer " + getApiToken())
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            if (response.code() == 200) {
                JSONObject responseBody = new JSONObject(response.body().string());
                JSONArray results = responseBody.getJSONArray("items");

            }
            else {
                throw new RuntimeException("Response not successful");
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
