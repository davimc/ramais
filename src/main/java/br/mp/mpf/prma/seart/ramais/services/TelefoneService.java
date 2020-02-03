package br.mp.mpf.prma.seart.ramais.services;

import br.mp.mpf.prma.seart.ramais.domain.Telefone;
import br.mp.mpf.prma.seart.ramais.repositories.TelefoneRepository;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    TelefoneRepository telefoneRepository;
    @Transactional
    public void inserir(Telefone telefone) throws TelefoneException {
        try{
            telefoneRepository.save(telefone);
        }catch (ConstraintViolationException e){
            throw new TelefoneException(e);
        }
    }
    @Transactional
    public void remover(Telefone telefone){
        telefoneRepository.delete(telefone);
    }
    @Transactional
    public Telefone encontraPorId(long id){
        return telefoneRepository.getOne(id);
    }
}
