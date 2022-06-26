package com.senatelecom.assignment.service;

import com.senatelecom.assignment.model.Input;
import com.senatelecom.assignment.model.Output;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class WordCounterService {
    public Output count( Input input){
        HashMap wordsWithOccurrence = new HashMap<String , Integer> ();
        List<String> splitedSentence = Arrays.asList ( input.getSentence ( ).toLowerCase ().split ( " " ) );
        for (String word : splitedSentence) {
            wordsWithOccurrence.computeIfPresent ( word, (key, val) -> (Integer)val + 1);
            wordsWithOccurrence.putIfAbsent ( word,1 );
        }
        Output output =  new Output ();
        output.setWordsWithOccurrence ( wordsWithOccurrence );
        return output;
    }
}
