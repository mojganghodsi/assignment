package com.senatelecom.assignment;

import com.senatelecom.assignment.controller.WordCounterController;
import com.senatelecom.assignment.model.Output;
import com.senatelecom.assignment.service.WordCounterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author mojgan
 * test class for charging API testing
 *
 * using junit for testing
 * Mockito for mocking objects
 * JSONAssert for testing json strings
 */

@ContextConfiguration(classes = AssignmentApplication.class)
@WebMvcTest(value = WordCounterController.class)
public class AssignmentAPITest implements JsonMapper{
    @Autowired
    private MockMvc mvc;
    @MockBean
    private WordCounterService wordCounterService;

    @BeforeEach
    void setUp(){

    }

    @Test
    public void chargeAPITest() throws Exception {
        Output output = new Output();
        String stringInput = "{";
        String expectedOutput = "{}";
        Mockito.when(wordCounterService.count (Mockito.any())).thenReturn(output);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/wordcounter/count").content(stringInput).contentType(MediaType.APPLICATION_JSON_VALUE);
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        /*
        in case of equal assertion for objects
        Output outputObject = mapFromJson(expectedOutput, Output.class);
        Assertions.assertEquals(outputObject,mapFromJson(result.getResponse().getContentAsString(), Output.class));
        */
        String actualOutPut = result.getResponse().getContentAsString();
        JSONAssert.assertEquals(expectedOutput, actualOutPut, false);
    }

}


