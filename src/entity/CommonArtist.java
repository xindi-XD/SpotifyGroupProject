package entity;

public class CommonArtist implements Artist {
    private final String name;
    private final String id;
    public CommonArtist(String name, String id){
        this.name = name;
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }
}
