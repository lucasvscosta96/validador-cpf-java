package com.validador.Validador.Controllers;

import com.validador.Validador.Models.Cliente;

import org.springframework.boot.autoconfigure.validation.ValidatorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.validador.Validador.Models.Cliente;

@Controller
public class HomeController {

    @GetMapping("/")
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "home/index";
    }

    @PostMapping("/valida-cpf")
    public String validaCpf(Cliente cliente, Model model){
        //if(cliente.validarCpf()){
            model.addAttribute("cliente", cliente);
            model.addAttribute("validado", cliente.validarCpf());
            return "home/cpfValidado";
        //}
        //return "home/cpfInvalido";
    }
}