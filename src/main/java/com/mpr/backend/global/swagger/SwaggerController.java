package com.mpr.backend.global.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {
    @GetMapping("/api/document")
    public String redirectSwagger(){
        return "redirect:/swagger-ui/index.html";
    }
}
