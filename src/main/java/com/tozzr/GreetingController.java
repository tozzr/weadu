package com.tozzr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	@RequestMapping("/")
    public String index() {
        return "index";
    }
	
    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

}
