package use_case.search;

public class SearchOutputData {
    // TODO: song type is Object, change to string when assured.
    private final Object song;
    private String creationTime;
    private boolean useCaseFailed;
    public SearchOutputData(Object song, String creationTime, boolean useCaseFailed){
        this.creationTime = creationTime;
        this.song = song;
        this.useCaseFailed = useCaseFailed;
    }
    public Object getSong(){
        return this.song;
    }
    public String getCreationTime(){
        return this.creationTime;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
