package io.juliocdet.helloworldspring.controller;

import io.juliocdet.helloworldspring.model.Entrada;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/circo")
public class CircoController {

    @PostMapping("/enviar-entradas/{numEntradas}")
    public String enviarEntradas(@PathVariable("numEntradas") int numEntradas,
                                 @RequestBody Entrada entrada,
                                 Model model){
        model.addAttribute("entrada", entrada);
        return "circo-entradas";
    }
}
