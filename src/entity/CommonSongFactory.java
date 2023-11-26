package entity;

import java.util.ArrayList;

public class CommonSongFactory implements SongFactory {
    @Override
    public CommonSong create(String name, String[] artist, String id) {
        return new CommonSong(name, artist, id);
    }
}
