package interface_adapter.create_playlist;

import interface_adapter.homepage.HomepageViewModel;

public class CreatePlaylistViewModel extends HomepageViewModel {
    private CreatePlaylistState state = new CreatePlaylistState();
    public CreatePlaylistViewModel(){
        super(); // TODO So it can't be super class of anything? Not sure how super works.
    }

    public void setState(CreatePlaylistState state) {
        this.state = state;
    }

    // getCreatePlaylistState method overrides the one from HomepageViewModel.
    public CreatePlaylistState getCreatePlaylistState() {return state;}
}
