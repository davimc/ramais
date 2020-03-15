package br.mp.mpf.prma.seart.ramais.controllers;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.services.ContatoService;
import br.mp.mpf.prma.seart.ramais.services.exceptions.ContatoException;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import br.mp.mpf.prma.seart.ramais.services.forms.ContatoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    /*Métodos GET*/
    @GetMapping
    public List<Contato> listaDeContatos(){
        return contatoService.listaTodosContatos();
    }

    @PostMapping(path="/nome", produces= MediaType.APPLICATION_JSON_VALUE)
    public Optional<Contato> listaContatoPeloNome(@RequestBody String nome){
        return contatoService.buscarPorNome(nome);
    }
    @GetMapping("/setor{setor}")
    public Optional<Contato> listaContatoPeloSetor(@PathParam("setor") String setor){
        return contatoService.buscarPorRamal(setor);
    }


    /*Métodos POST*/
    @PostMapping
    public void adicionarContato(ContatoForm form){
        try {
            contatoService.inserir(form.converter());
        } catch (ContatoException e) {
            e.printStackTrace();
        } catch (TelefoneException e) {
            e.printStackTrace();
        }
    }

    /*Métodos PUT*/
    @PutMapping
    public void atualizaContato(ContatoForm form, Contato contato){

    }

    /*Métodos DELETE*/
}
