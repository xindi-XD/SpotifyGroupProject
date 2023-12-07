package interface_adapter.show_songs;

import java.util.Map;

public class ShowSongsState {
    private String noSongsError;
    private Map<String, String[]> songs;
    public ShowSongsState() {}

    public void setNoSongsError(String error) {
        this.noSongsError = error;
    }

    public String getNoSongsError() {
        return noSongsError;
    }
}
