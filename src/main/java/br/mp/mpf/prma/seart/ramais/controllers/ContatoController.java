package br.mp.mpf.prma.seart.ramais.controllers;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.services.ContatoService;
import br.mp.mpf.prma.seart.ramais.services.exceptions.ContatoException;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import br.mp.mpf.prma.seart.ramais.services.forms.ContatoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @GetMapping("/nome={nome}")
    public Optional<Contato> listaContatoPeloNome(@PathParam("nome") String nome){
        return contatoService.buscarPorNome(nome);
    }
    @GetMapping("/ramal{ramal}")
    public Optional<Contato> listaContatoPeloRamal(@PathParam("ramal") String ramal){
        return contatoService.buscarPorRamal(ramal);
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
