package com.senatelecom.assignment.model;

import java.io.Serializable;

public class Input implements Serializable {
    String sentence;

    public String getSentence ( ) {
        return sentence;
    }

    public void setSentence ( String sentence ) {
        this.sentence = sentence;
    }
}
