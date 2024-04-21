package com.jk.springsecurity.authnauth;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Calculation", description = "Currently only sum operation is supported")
@RestController
@RequestMapping("calc")
public class SecuredController {

    @GetMapping("sum")
    public int add(int a, int b) {
        return a+b;
    }
}
