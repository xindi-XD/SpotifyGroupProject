package use_case.delete_playlist;

public interface DeletePlaylistDataAccessInterface {
    boolean existsPlaylistName(String name);
    void delete(String name);
}
