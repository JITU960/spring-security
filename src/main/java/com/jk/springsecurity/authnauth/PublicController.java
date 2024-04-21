package com.jk.springsecurity.authnauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class PublicController {

    @GetMapping("qt")
    public String showQuote() {
        String[] q = {
          "Honesty is the best policy",
          "Work hard, party harder",
          "Slow and steady wins the race"
        };

        int rand = ((int)(Math.random()*1000)) % 3;
        return q[rand];
    }
}
