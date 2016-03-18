package com.summarizer.news.sentence.extractor;

import com.summarizer.news.data.html.HtmlReader;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ushan on 3/5/16.
 */
public class SentenceExtractor {
    private List<String[]> wordsInDocuments = new ArrayList<String[]>(); //this will hold all the words in document
    private List<String> allWords =
            new ArrayList<String>(); //this all words set will hold all the unique words in wordsInDocuments
    private List<String> allSentences = new ArrayList<String>();

    public  String[] getExtractedWordInGivenDocument(StringBuilder builder){
        String[] tokenizedTerms = builder.toString().
                replaceAll("[\\W&&[^\\s]]", "").split("\\W+");//to get individual terms
        for (String term : tokenizedTerms) {
            if (!allWords.contains(term)) {  //avoid duplicate entry
                allWords.add(term);
            }
        }
        wordsInDocuments.add(tokenizedTerms);
        return tokenizedTerms;
    }

    public  List<String[]> getWordsInDocuments(){
        return  this.wordsInDocuments;
    }

    public  List<String> getAllWords(){
        return  this.allWords;
    }

    public void extractSentenceInDocument(StringBuilder builder){
        String document  =  builder.toString();
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(document);
        String sentence = "";
        //String[] sentencesInDocument = document.split("(?<=[a-z])\\.\\s+");
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
             sentence =  document.substring(start,end);
             System.out.println(sentence+"==========================");
             if(!allSentences.contains(sentence)){
                allSentences.add(sentence);
             }
        }
    }

//    public static void main(String[] args) {
//
//        try {
////            StringBuilder stringBuilder = HtmlReader.readHTML("http://www.dailynews.lk/?q=2016/03/09/local/" +
////                    "thai-deputy-prime-minister-meets-foreign-minister");
//            StringBuilder stringBuilder = HtmlReader.
//                    readHTML("http://www.espncricinfo.com/icc-world-twenty20-2016/content/story/984837.html");
//
//            SentenceExtractor sentenceExtractor =  new SentenceExtractor();
//            sentenceExtractor.extractSentenceInDocument(stringBuilder);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
