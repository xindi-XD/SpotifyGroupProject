package use_case.delete_playlist;

public class DeletePlaylistInputData {
    final private String name;
    public DeletePlaylistInputData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
