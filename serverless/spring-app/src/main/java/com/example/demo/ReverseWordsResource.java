package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ReverseWordsResource
 */
@RestController
public class ReverseWordsResource {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE, path = "/reverse")
    @ResponseBody
    public String reverse(@RequestParam String text) {
        return new StringBuilder(text).reverse().toString();
    }
    
}