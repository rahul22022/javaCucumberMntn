import com.automation.cucumber.Helper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class tester {
    public static void main(String[] args){

        Helper help = new Helper();
        JSONObject jobj = help.readJson("src/main/resources/fixtures.json");
        JSONArray body = new JSONArray();
        ArrayList<Object> listOfTests = new ArrayList<>();
        for(Object keys: jobj.keySet()){
            body.add((JSONObject)jobj.get(keys));
        }


    }
}
