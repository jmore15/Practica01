package com.practica01.controller;

import com.practica01.domain.Pais;
import com.practica01.service.PaisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class indexController {
    
    @Autowired
    PaisService PaisService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("ahora desde MVC");

        var paises = PaisService.getPaises();
        model.addAttribute("paises", paises);
        return "index";
    }

    @GetMapping("/nuevoPais")
    public String nuevoPais(Pais pais) {
        return "modificarPais";
    }

    @PostMapping("/guardarPais")
    public String guardarPais(Pais pais) {
        PaisService.save(pais);
        return "redirect:/";
    }

    @GetMapping("/modificarPais/{idPais}")
    public String modificarPais(Pais pais, Model model) {
        pais = PaisService.getPais(pais);
        model.addAttribute("pais", pais);
        return "modificarPais";
    }

    @GetMapping("/eliminarPais/{idPais}")
    public String eliminarPais(Pais pais) {
        PaisService.delete(pais);
        return "redirect:/";
    }
    
}
