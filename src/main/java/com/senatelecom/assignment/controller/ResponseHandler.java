package com.senatelecom.assignment.controller;

import com.senatelecom.assignment.util.DateConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler implements DateConverter {

    public static ResponseEntity generateResponse( String message, HttpStatus status, Object responseObj) {
        Map<String, Object> body = new HashMap();
        body.put("message", message);
        body.put("status", status.value());
        body.put("data", responseObj);
        body.put("timestamp", DateConverter.getLocalDateTimeAsString());

        return new ResponseEntity(body,status);
    }

}
