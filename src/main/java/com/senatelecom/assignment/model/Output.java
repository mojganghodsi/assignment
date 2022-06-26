package com.senatelecom.assignment.model;

import com.senatelecom.assignment.lib.CustomizedConcurrentHashmap;

import java.io.Serializable;
import java.util.Map;

public class Output implements Serializable {
    CustomizedConcurrentHashmap<String , Integer> wordsWithOccurrence;
    public Map<String, Integer> getWordsWithOccurrence ( ) {
        return wordsWithOccurrence;
    }

    public void setWordsWithOccurrence ( CustomizedConcurrentHashmap<String, Integer> wordsWithOccurrence ) {
        this.wordsWithOccurrence = wordsWithOccurrence;
    }

    @Override
    public int hashCode ( ) {
        return super.hashCode ( );
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Output)) {
            return false;
        }
        Output output = (Output) o;
        return output.getWordsWithOccurrence ().equals ( this.getWordsWithOccurrence () );
    }

}
