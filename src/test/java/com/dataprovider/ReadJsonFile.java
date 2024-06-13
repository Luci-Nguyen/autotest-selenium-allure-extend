package com.dataprovider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.now;

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
        LocalDateTime s = LocalDateTime.now();
        System.out.println(s.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}
