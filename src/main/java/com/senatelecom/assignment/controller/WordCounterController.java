package com.senatelecom.assignment.controller;

import com.senatelecom.assignment.model.Input;
import com.senatelecom.assignment.model.Output;
import com.senatelecom.assignment.service.WordCounterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wordcounter")
public class WordCounterController {
    WordCounterService wordCounterService;

    /***
     * Injecting dependencies via constructor
     */
    @Autowired
    public WordCounterController(WordCounterService wordCounterService) {
        this.wordCounterService = wordCounterService;
    }

    /***
     * Implemented restFull API to expose the charging process endpoint
     * @param input
     * @return ResponseEntity
     */
    @ApiOperation(value = "start the counting process", response = Iterable.class, tags = "countword")
    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public ResponseEntity count( @RequestBody Input input) {
        Output output =  wordCounterService.count(input);
        //return ResponseEntity.status( HttpStatus.OK).body(output);
        return ResponseHandler.generateResponse ("Counting successfully finished!",HttpStatus.OK,output);
    }
}
