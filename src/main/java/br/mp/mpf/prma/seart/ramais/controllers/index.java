package br.mp.mpf.prma.seart.ramais.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class index {
    @Autowired
    ContatoController contatoController;
    @GetMapping
    public void index(){
        contatoController.listaContatoPeloNome("");
    }
}
