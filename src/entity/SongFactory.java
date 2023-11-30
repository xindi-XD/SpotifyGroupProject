package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public interface SongFactory {

    CommonSong create(String name, String[] artist, String[] genres, String id);
}
