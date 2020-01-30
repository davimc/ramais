package br.mp.mpf.prma.seart.ramais.services;

import br.mp.mpf.prma.seart.ramais.domain.Setor;
import br.mp.mpf.prma.seart.ramais.repositories.SetorRepository;
import br.mp.mpf.prma.seart.ramais.services.exceptions.SetorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class SetorService {
    @Autowired
    SetorRepository setorRepository;
    public void inserir(Setor setor) throws SetorException {
        try{
            setorRepository.save(setor);
        }catch (ConstraintViolationException e){
            throw new SetorException(e);
        }
    }
    public void remover(Setor setor){
        setorRepository.delete(setor);
    }

}
