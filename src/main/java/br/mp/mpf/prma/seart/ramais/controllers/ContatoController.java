package br.mp.mpf.prma.seart.ramais.controllers;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    private ContatoService contatoService;
    @RequestMapping("/contatos")
    public List<Contato> listaDeContatos(){
        return contatoService.listaTodosContatos();
    }
}
