package com.summarizer.news.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ushan on 3/13/16.
 */
public class GoogleNewsAPIClient {

    public static void getNewsUrls(String keyword) throws IOException {

        URL url = new URL("https://ajax.googleapis.com/ajax/services/search/news?" +
                "v=1.0&q="+keyword+"&userip=INSERT-USER-IP");
        URLConnection connection = url.openConnection();
        //connection.addRequestProperty("Referer");
        connection.addRequestProperty("method","GET");

        String line;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while((line = reader.readLine()) != null) {
            builder.append(line);
        }

        JsonParser  jsonParser =  new JsonParser();
        JsonObject responseObj = (JsonObject) jsonParser.parse(builder.toString());
        System.out.println(responseObj.toString());
    }

    public static void main(String[] args) {
        try {
            getNewsUrls("T20%20World%20cup%202016");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
