package io.juliocdet.helloworldspring.controller;

import io.juliocdet.helloworldspring.model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/example")
public class HelloWorldController {

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "hello-world";
    }

    @GetMapping("/bye/{nombre}")
    public String getByeMessage() {
        return "bye-world";
    }

    @GetMapping("/thymeleaf")
    public String getExample(Model model, @RequestParam String nombre, @RequestParam int edad) {
        Persona persona = new Persona(nombre, edad);
        model.addAttribute("persona", persona);
        return "thymeleaf";
    }
}
