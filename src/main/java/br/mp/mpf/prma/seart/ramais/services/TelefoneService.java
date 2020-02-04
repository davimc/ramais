package br.mp.mpf.prma.seart.ramais.services;

import br.mp.mpf.prma.seart.ramais.domain.Telefone;
import br.mp.mpf.prma.seart.ramais.repositories.TelefoneRepository;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AutoPopulatingList;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;
    @Transactional
    public void inserir(Telefone telefone) throws TelefoneException {
        if(!telefoneRepository.findByNumero(telefone.getNumero()).isPresent())
            try{

                telefoneRepository.save(telefone);
            }catch (ConstraintViolationException e){
                e.getMessage();
            }
        else
            throw new TelefoneException(new Exception("Telefone já está cadastrado no sistema"));

    }
    @Transactional
    public void remover(Telefone telefone){
        telefoneRepository.delete(telefone);
    }
    @Transactional
    public Optional<Telefone> encontraPorId(long id){
        return telefoneRepository.findById(id);
    }

    public Optional<Telefone> encontraPorNumero(String numero){
        return telefoneRepository.findByNumero(numero);
    }
}
