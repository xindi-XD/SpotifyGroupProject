package use_case.search;

public class SearchInputData {
    final private String query;
    final private String queryType;
    public SearchInputData(String query, String queryType){
        this.query = query;
        this.queryType = queryType;
    }
    String getQuery(){return this.query;}
    String getQueryType(){return this.queryType;}

}
