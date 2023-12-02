package use_case.search;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public interface ResultCompiler {
    ArrayList compileResult(JSONArray results);
}
