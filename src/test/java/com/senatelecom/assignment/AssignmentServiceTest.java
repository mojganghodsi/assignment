package com.senatelecom.assignment;

import com.senatelecom.assignment.lib.CustomizedConcurrentHashmap;
import com.senatelecom.assignment.model.Input;
import com.senatelecom.assignment.model.Output;
import com.senatelecom.assignment.service.WordCounterService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.HashMap;

/**
 * @author mojgan
 * test class for service class test
 *
 * using junit for testing
 * Mockito for mocking objects
 * JSONAssert for testing json strings
 */

@SpringBootTest
public class AssignmentServiceTest {
    @Autowired
    WordCounterService wordCounterService;

    @BeforeEach
    void setup(){

    }

    @Test
    void ChargingProcessTest() throws Exception{
        Input input = new Input ();
        input.setSentence ("This is a test I designed to test a candidate.");
        Output output = new Output ();
        CustomizedConcurrentHashmap wordsWithOccurrence = new CustomizedConcurrentHashmap<String , Integer> ();
        wordsWithOccurrence.put("this",1);
        wordsWithOccurrence.put("is",1);
        wordsWithOccurrence.put("a",2);
        wordsWithOccurrence.put("test",2);
        wordsWithOccurrence.put("i",1);
        wordsWithOccurrence.put("designed",1);
        wordsWithOccurrence.put("to",1);
        wordsWithOccurrence.put("candidate.",1);
        output.setWordsWithOccurrence (wordsWithOccurrence);
        Assert.assertEquals(wordCounterService.count (input),output);
    }

}
