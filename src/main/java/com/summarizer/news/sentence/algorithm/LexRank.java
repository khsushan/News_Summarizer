package com.summarizer.news.sentence.algorithm;

import com.summarizer.news.sentence.extractor.SentenceExtractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ushan on 3/16/16.
 */
public class LexRank {
    private List<String[]> wordsInDocuments = null;
    private List<String> allWords = null;
    private List<String> allSentences = null;
    private StringBuilder[] documents =  null;
    private SentenceExtractor sentenceExtractor;
    private Double[][] cosineMaxtrics =null;

    public LexRank(StringBuilder[] documents){
        this.documents = documents;
        sentenceExtractor =  new SentenceExtractor();
        init();
    }

    private void init(){
        for (StringBuilder document : documents){
            sentenceExtractor.extractSentenceInDocument(document);
            sentenceExtractor.getExtractedWordInGivenDocument(document);
        }
        this.wordsInDocuments =  sentenceExtractor.getWordsInDocuments();
        this.allWords = sentenceExtractor.getAllWords();
        this.allSentences =  sentenceExtractor.getAllSentences();
        this.cosineMaxtrics = new Double[allSentences.size()][allSentences.size()];
    }

    private void calculateLexRankScore(){
        for(int i = 0; i < allSentences.size() ; i++){
            for (int j =0; j < allSentences.size(); j++){
                cosineMaxtrics[i][j] = 0.0;
            }
        }
    }

    private void calculateIDFModifiedCosine(){

    }



}
