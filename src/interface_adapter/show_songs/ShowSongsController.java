package interface_adapter.show_songs;

import use_case.show_songs.ShowSongsInputBoundary;
import use_case.show_songs.ShowSongsInputData;

public class ShowSongsController {
    final ShowSongsInputBoundary showSongsInteractor;
    public ShowSongsController(ShowSongsInputBoundary showSongsInteractor) {
        this.showSongsInteractor = showSongsInteractor;
    }

    public void execute(String playlistName) {
        ShowSongsInputData showSongsInputData = new ShowSongsInputData(playlistName);
        showSongsInteractor.execute(showSongsInputData);
    }
}
