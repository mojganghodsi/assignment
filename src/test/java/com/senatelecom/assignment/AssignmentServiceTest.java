package com.senatelecom.assignment;

import com.senatelecom.assignment.model.Input;
import com.senatelecom.assignment.model.Output;
import com.senatelecom.assignment.service.WordCounterService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

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
/*        Input input = new Input ();
        Output output = new Output ();
        Assert.assertEquals(wordCounterService.count (input),output);*/
    }

}
