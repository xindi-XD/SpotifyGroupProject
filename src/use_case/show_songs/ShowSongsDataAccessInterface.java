package use_case.show_songs;

import java.util.Map;

public interface ShowSongsDataAccessInterface {
    boolean noExistsSongs(String playlistName);

    Map<String, String> getSongs(String playlistName);
}
