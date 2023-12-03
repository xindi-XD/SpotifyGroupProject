package use_case.search.search_strategies;

import org.json.JSONArray;

import java.util.ArrayList;

public interface Compiler {
    ArrayList compileResult(JSONArray results);
}
