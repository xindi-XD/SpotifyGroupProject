package interface_adapter.homepage;

public class HomepageState {
    private String homepageError = null;
    private String query = "";
    private String queryType = "";

    public HomepageState(HomepageState copy) {
        this.homepageError = copy.homepageError;
        this.query = copy.query;
    }

    public HomepageState() {}

    public String getHomepageError() {return this.homepageError;}
    public String getQuery(){return this.query;}
    public String getQueryType() {return this.queryType;}

    public void setHomepageError(String error) {this.homepageError = error;}
    public void setQuery(String query) {this.query = query;}
    public void setQueryType(String type){this.queryType = type;}


}
