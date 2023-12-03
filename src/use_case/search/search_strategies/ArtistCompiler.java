package use_case.search.search_strategies;

import entity.CommonArtist;
import entity.CommonArtistFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.search.search_strategies.Compiler;

import java.util.ArrayList;

public class ArtistCompiler implements Compiler {

    @Override
    public ArrayList<CommonArtist> compileResult(JSONArray results) {
        ArrayList<CommonArtist> artists = new ArrayList<>();
        for (int i = 0; i < results.length(); i++) {
            JSONObject result = (JSONObject) results.get(i);
            CommonArtist artist = CommonArtistFactory.create(result);
            artists.add(artist);
        }
        return artists;
    }
}
