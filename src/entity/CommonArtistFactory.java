package entity;

import org.json.JSONObject;

public class CommonArtistFactory implements ArtistFactory{
    @Override
    public CommonArtist create(String name, String id) {
        return new CommonArtist(name, id);
    }

    public static CommonArtist create(JSONObject object) {
        return new CommonArtist(object.getString("name"),
                object.getString("id"));
    }
}
