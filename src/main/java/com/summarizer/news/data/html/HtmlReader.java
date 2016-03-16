package com.summarizer.news.data.html;

import com.summarizer.news.sentence.extractor.SentenceExtractor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

/**
 * This class is use to read html content in given link
 */
public class HtmlReader {

    public static StringBuilder readHTML(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        String title = document.title();
        Elements paragraphs = document.body().select("p");
        StringBuilder content = new StringBuilder();
        for (Element element : paragraphs) {
            //removing advertisement tag
            if (!element.text().equals("Advertisement") &&
                    !element.text().contains("|") &&
                    !element.text().contains(":") &&
                    !(element.text().trim().split(" ").length == 1) &&
                    !(element.text().trim().contains("Home Page"))) {
                content.append(element.text());
                content.append("\n");
            }

        }
        return content;
    }

    public static void main(String[] args) {
        try {
            //readHTML("http://www.dailynews.lk/?q=2016/03/09/local/thai-deputy-prime-minister-meets-foreign-minister");
            StringBuilder htmlContent = readHTML("http://www.dailynews.lk/?q=2016/03/09/local/" +
                    "thai-deputy-prime-minister-meets-foreign-minister");
            SentenceExtractor sentenceExtractor = new SentenceExtractor();
            String[] extractedSenetence = sentenceExtractor.getExtractedWordInGivenDocument(htmlContent);
            System.out.println(extractedSenetence);

            //readHTML("http://www.nytimes.com/2016/03/10/world/middleeast/obama-criticizes-the-free-riders-among-americas-allies.html?_r=0");
            //readHTML("http://www.dailynews.lk/?q=2016/03/10/local/basil-rajapaksa-released-bail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
