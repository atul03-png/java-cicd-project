package com.devops.hello;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "message", "Hello from Jenkins CI/CD Pipeline!",
            "status",  "running",
            "version", "1.0.0"
        );
    }

    @GetMapping("/hello/{name}")
    public Map<String, String> hello(@PathVariable String name) {
        return Map.of(
            "message", "Hello, " + name + "!",
            "status",  "running"
        );
    }
}
