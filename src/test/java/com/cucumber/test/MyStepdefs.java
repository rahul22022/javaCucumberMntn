package com.cucumber.test;

import com.automation.cucumber.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {
    Helper help = new Helper();
    JSONObject getFixtures = help.readJson("src/main/resources/fixtures.json");
    JSONArray body = new JSONArray();
    String url = "";
    JSONObject payload = new JSONObject();
    Response response ;

    @Given("job is running and available for (.*)$")
    public void job_is_running(String method) {
        ArrayList<Object> listOfTests = new ArrayList<>();
        for(Object keys: getFixtures.keySet()){
            body.add((JSONObject)getFixtures.get(keys));
        }
//
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @When("when we send a request for (.*) and (.*) and requested operation is (.*) and action is (.*)$")
    public void when_we_send_a_request(String api,String status,String method,String action) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        JSONObject getValues = new JSONObject();
        Method setMethodName;
        for(int i = 0 ; i < body.size();i++){
            JSONObject getOptions = (JSONObject) body.get(i);
            getValues = (JSONObject) getOptions.get(action);
            if(getValues != null){
                url = (String) getValues.get("url");
                String methodName = (String) getValues.get("method");
                payload = (JSONObject) getValues.get("payload");
                Class<?> className = Class.forName("com.automation.cucumber.Helper");
                Object obj = className.getDeclaredConstructor().newInstance();
                if(methodName.matches("postRequest|putRequest")){
                    setMethodName  =  className.getMethod(methodName,String.class,JSONObject.class);
                    System.out.println(payload);
                    System.out.println(url);
                    response = (Response)setMethodName.invoke(obj,url,payload);
                }
                else{
                    setMethodName  =  className.getMethod(methodName,String.class);
                    response = (Response)setMethodName.invoke(obj,url);
                }


            }
        }

    }
    @Then("response code is (.*) is (.*)$")
    public void response_code(String action,Integer status) {
        Integer statusCode = (Integer) response.statusCode();
        System.out.println(response.getBody().prettyPrint());
        assertEquals(statusCode,status);
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

}
