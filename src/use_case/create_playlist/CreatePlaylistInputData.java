package use_case.create_playlist;

public class CreatePlaylistInputData {
    final private String name;

    final private String description;
    public CreatePlaylistInputData(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
