package com.senatelecom.assignment.model;

import java.io.Serializable;
import java.util.HashMap;

public class Output implements Serializable {
    HashMap<String , Integer> wordsWithOccurrence;

    public HashMap<String, Integer> getWordsWithOccurrence ( ) {
        return wordsWithOccurrence;
    }

    public void setWordsWithOccurrence ( HashMap<String, Integer> wordsWithOccurrence ) {
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
        return output.getWordsWithOccurrence ().equals ( ((Output) o).getWordsWithOccurrence () );
    }

}
