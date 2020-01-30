package br.mp.mpf.prma.seart.ramais.services;

import br.mp.mpf.prma.seart.ramais.domain.Telefone;
import br.mp.mpf.prma.seart.ramais.repositories.TelefoneRepository;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class TelefoneService {
    @Autowired
    TelefoneRepository telefoneRepository;
    public void inserir(Telefone telefone) throws TelefoneException {
        try{
            telefoneRepository.save(telefone);
        }catch (ConstraintViolationException e){
            throw new TelefoneException(e);
        }
    }
    public void remover(Telefone telefone){
        telefoneRepository.delete(telefone);
    }

}
