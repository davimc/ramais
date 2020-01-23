package br.mp.mpf.prma.seart.ramais.services;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.repositories.ContatoRepository;
import br.mp.mpf.prma.seart.ramais.services.exceptions.ContatoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class ContatoService {
    @Autowired
    ContatoRepository contatoRepository;
    public void inserir(Contato contato) throws ContatoException {
        try{
            contatoRepository.save(contato);
        }catch (ConstraintViolationException e){
            throw new ContatoException(e);
        }
    }
    public void removerPorId(Contato contato){
        contatoRepository.delete(contato);
    }
}
