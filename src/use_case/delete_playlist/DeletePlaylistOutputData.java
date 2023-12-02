package use_case.delete_playlist;

public class DeletePlaylistOutputData {
    private final String name;
    public DeletePlaylistOutputData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
