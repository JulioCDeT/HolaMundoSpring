package io.juliocdet.helloworldspring.controller;

import io.juliocdet.helloworldspring.model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/example")
public class HelloWorldController {

    private final int EDAD_DEFAULT = 20;

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

    @GetMapping("/datos-usuario/{nombre}/{edad}")
    public String getDatosUsuario(@PathVariable("nombre") String nombre,
                                  @PathVariable("edad") int edad,
                                  Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("edad", edad);
        return "datos-usuario";
    }

    @GetMapping("/datos-usuario")
    public String getDatosUsuario2(@RequestParam("nombre") String nombre,
                                  @RequestParam("edad") int edad,
                                  Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("edad", edad);
        return "datos-usuario";
    }

    @GetMapping("/datos-usuario/{nombre}")
    public String getDatosUsuario(@PathVariable("nombre") String nombre,
                                  Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("edad", EDAD_DEFAULT);
        return "datos-usuario";
    }
}
