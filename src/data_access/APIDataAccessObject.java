package data_access;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.search.SearchAPIDataAccessInterface;

import java.io.IOException;
import java.util.Base64;

public class APIDataAccessObject implements SearchAPIDataAccessInterface {
    private static final String CLIENT_ID = System.getenv("CLIENT_ID");
    private static final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");

    private static String getClientCredentials() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create("grant_type=client_credentials", mediaType);
        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .method("POST", body)
                .addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes()))
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

                // Throw a more informative exception
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

                // Throw a more informative exception
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

                // Throw a more informative exception
                throw new RuntimeException("Response not successful. See console for details.");
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
