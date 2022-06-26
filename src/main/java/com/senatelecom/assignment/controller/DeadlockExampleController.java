package com.senatelecom.assignment.controller;

import com.senatelecom.assignment.service.DeadLockExampleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadlockexample")
public class DeadlockExampleController {
    DeadLockExampleService deadLockExampleService;

    /***
     * Injecting dependencies via constructor
     */
    @Autowired
    public DeadlockExampleController( DeadLockExampleService deadLockExampleService) {
        this.deadLockExampleService = deadLockExampleService;
    }

    /***
     * Implemented restFull API to expose the deadlock example endpoint
     * @return ResponseEntity
     */
    @ApiOperation(value = "start the deadlock condition", response = Iterable.class, tags = "deadlock")
    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public ResponseEntity runDeadlockExample() {
        deadLockExampleService.runDeadlockExample ();
        return ResponseHandler.generateResponse ("check the console logs for information about deadlock condition!", HttpStatus.OK, null);
    }
}
