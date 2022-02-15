package com.automation.cucumber;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class Helper {


    public Response getRequest(String url){
        Response getResponse =  given()
                .contentType(JSON)
                .when()
                .get(url)
                .then()
                .extract().response();
        return getResponse;

    }
    public Response postRequest(String url,JSONObject payload){
        Response getResponse = given()
                .header("Content-type", "application/json")
                .and()
                .body(payload)
                .when()
                .post(url)
                .then()
                .extract().response();

        return getResponse;

    }

    public Response putRequest(String url,JSONObject payload) {

        Response getResponse = given()
                .header("Content-type", "application/json")
                .and()
                .body(payload)
                .when()
                .put(url)
                .then()
                .extract().response();

        return getResponse;
    }
    public Response deleteRequest(String url) {

        Response getResponse = given()
                .header("Content-type", "application/json")
                .when()
                .delete(url)
                .then()
                .extract().response();

    return getResponse;
    }

    public JSONObject readJson(String filename) {
        JSONObject jobj = new JSONObject();

        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {
            jobj = (JSONObject) parser.parse(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jobj;
    }

    }
