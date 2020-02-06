package br.mp.mpf.prma.seart.ramais.services;

import br.mp.mpf.prma.seart.ramais.domain.Setor;
import br.mp.mpf.prma.seart.ramais.repositories.SetorRepository;
import br.mp.mpf.prma.seart.ramais.services.exceptions.SetorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Service
public class SetorService {
    @Autowired
    SetorRepository setorRepository;
    @Transactional
    public void inserir(Setor setor) throws SetorException {
        if(!setorRepository.findByNome(setor.getNome()).isPresent()) {
            try {
                setorRepository.save(setor);
            } catch (ConstraintViolationException e) {
                throw new SetorException(e);
            }
        }
        else
            throw new SetorException(new Exception("Setor já está cadastrado no sistema"));
    }
    /*atenção ao atualizar!!
    TENHA CERTEZA QUE ESTE CONTATO JÁ EXISTE NO BD OU ENTÃO HAVERÁ DUPLICIDADE
    */

    public void atualizar(Setor setor)  {
        setorRepository.save(setor);
    }
    @Transactional
    public void remover(Setor setor){
        setorRepository.delete(setor);
    }

    public Optional<Setor> encontraPorNome(String nomeSetor){
        return setorRepository.findByNome(nomeSetor);
    }
}
