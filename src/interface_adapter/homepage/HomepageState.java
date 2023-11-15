package interface_adapter.homepage;

public class HomepageState {
    private String homepageError = null;

    public HomepageState(HomepageState copy) {
        this.homepageError = copy.homepageError;
    }

    public HomepageState() {}

    public String getHomepageError() {return this.homepageError;}

    public void setHomepageError(String error) {this.homepageError = error;}
}
