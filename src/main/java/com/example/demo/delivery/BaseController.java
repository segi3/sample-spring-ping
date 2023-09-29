package com.example.demo.delivery;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BaseController {

    @GetMapping(value = "health")
    ResponseEntity<?> create () {
        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Hello, world");
    }
}
