package use_case.create_playlist;

import java.util.Objects;

public class CreatePlaylistInputData {
    final private String name;

    final private String description;
    public CreatePlaylistInputData(String name, String description) {
        this.name = name;
        if (Objects.equals(description, null) || description.length() <= 1) {
            this.description = null;
        }
        else {
            this.description = description;
        }
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
