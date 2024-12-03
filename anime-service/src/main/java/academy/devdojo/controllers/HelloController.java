package academy.devdojo.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greetings")
@ComponentScan(basePackages = { "outside.devdojo", "academy.devdojo" })
public class HelloController {

    @GetMapping("hi")
    public String hi() {
        return "omae wa mou shinde iru";
    }

}
