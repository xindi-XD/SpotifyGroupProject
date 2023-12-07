package use_case.show_songs;

import java.util.ArrayList;
import java.util.Map;

public class ShowSongsInteractor implements ShowSongsInputBoundary{
    final ShowSongsOutputBoundary showSongsPresenter;
    final ShowSongsDataAccessInterface showSongsDataAccessObject;
    public ShowSongsInteractor(ShowSongsOutputBoundary showSongsPresenter,
                               ShowSongsDataAccessInterface showSongsDataAccessObject) {
        this.showSongsPresenter = showSongsPresenter;
        this.showSongsDataAccessObject = showSongsDataAccessObject;
    }

    @Override
    public void execute(ShowSongsInputData showSongsInputData) {
        if (showSongsDataAccessObject.noExistsSongs(showSongsInputData.getPlaylist())) {
            showSongsPresenter.prepareFailView("Try to add one or more songs to this playlist! ^v^");
        }
        else {
            Map<String, String[]> songs = showSongsDataAccessObject.getSongs(showSongsInputData.getPlaylist());
            ShowSongsOutputData showSongsOutputData = new ShowSongsOutputData(songs);
            showSongsPresenter.prepareSuccessView(showSongsOutputData);
        }
    }
}
