package com.summarizer.news.sentence.extractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ushan on 3/5/16.
 */
public class SentenceExtractor {
    private List documents = new ArrayList<String[]>();
    private List allWords = new ArrayList<String>(); //to hold all terms

    public  String[] getExtractedWordInGivenDocument(StringBuilder builder){
        String[] tokenizedTerms = builder.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms
        for (String term : tokenizedTerms) {
            if (!allWords.contains(term)) {  //avoid duplicate entry
                allWords.add(term);
            }
        }
        documents.add(tokenizedTerms);
        return tokenizedTerms;
    }


}
