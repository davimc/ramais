package br.mp.mpf.prma.seart.ramais.controllers;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.services.ContatoService;
import br.mp.mpf.prma.seart.ramais.services.exceptions.ContatoException;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import br.mp.mpf.prma.seart.ramais.services.forms.ContatoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    /*Métodos GET*/
    @GetMapping
    public List<Contato> listaDeContatos(){
        return contatoService.listaTodosContatos();
    }

    @GetMapping
    public Optional<Contato> listaContatoPelo(String nome){
        return contatoService.buscarPorNome(nome);
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
