package br.mp.mpf.prma.seart.ramais.services;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.domain.Telefone;
import br.mp.mpf.prma.seart.ramais.repositories.ContatoRepository;
import br.mp.mpf.prma.seart.ramais.services.exceptions.ContatoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    ContatoRepository contatoRepository;
    @Autowired
    TelefoneService telefoneService;

    public void inserir(Contato contato) throws ContatoException {
        Optional<Telefone> telefone = telefoneService.encontraPorNumero(contato.getTelefone().getNumero());
        if( telefone.isPresent()) {
            if(telefone.get().isDisponivel()) {
                try {
                    contatoRepository.save(contato);
                } catch (ConstraintViolationException e) {
                    throw new ContatoException(e);
                }

            } else {

            }
        }else
            throw new ContatoException(new Exception("Telefone não foi cadastrado"));
    }

    public Optional<Contato> buscarPorNome(String nome){
        return contatoRepository.findByNome(nome);
    }

    public void remover(Contato contato){
        contatoRepository.delete(contato);
    }

    public List<Contato> listaTodosContatos(){
        return contatoRepository.findAll();
    }
}
