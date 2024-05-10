/*
package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Controller2 {
    @GetMapping("/example/{id}")
    public ResponseEntity<String> getExampleById(@PathVariable Long id){
        if (id == 1){
            return ResponseEntity.ok("Example with ID 1 found");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Example not found");
        }
    }
}
*/
