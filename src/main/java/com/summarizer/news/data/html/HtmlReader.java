package com.summarizer.news.data.html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * This class is use to read html content in given link
 */
public class HtmlReader {

    public static  String  readHTML(String link) throws IOException {
        URL oracle = new URL(link);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        String content  = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
            content = content.concat(inputLine);
        }
        in.close();
        return  null;
    }

    public static void main(String[] args) {
        try {
            readHTML("http://www.inquisitr.com/bangladesh-vs-pakistan-asia-cup-cricket-live-stream/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
