package use_case.search;

import entity.CommonSong;
import entity.CommonSongFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SongCompiler implements ResultCompiler {
    @Override
    public ArrayList<CommonSong> compileResult(JSONArray results) {
        ArrayList<CommonSong> songs = new ArrayList<>();
        for (int i = 0; i < results.length(); i++) {
            JSONObject result = (JSONObject) results.get(i);
            CommonSong song = CommonSongFactory.create(result);
            songs.add(song);
        }
        return songs;
    }
}
