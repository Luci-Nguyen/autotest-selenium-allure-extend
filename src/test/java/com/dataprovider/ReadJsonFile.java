package com.dataprovider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadJsonFile {
    public static Map<String, String> getJsonData(String s) throws IOException, ParseException {
        Map<String, String> nameMap = new HashMap<String, String>();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("datatest/user.json");
        Object obj = jsonParser.parse(reader);
        JSONObject users = (JSONObject) obj;
        JSONObject user = (JSONObject) users.get(s);
        String username = (String) user.get("username");
        String password = (String) user.get("password");
        nameMap.put("username", username);
        nameMap.put("password", password);
        return nameMap;
    }

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("username: " + getJsonData("users").get("username") + "\n" + "password: " + getJsonData("users").get("password"));
    }

}
