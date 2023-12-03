package use_case.search.search_strategies;

import entity.CommonSong;
import entity.CommonSongFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.search.search_strategies.Compiler;

import java.util.ArrayList;

public class SongCompiler implements Compiler {
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
