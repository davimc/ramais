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
                throw new TelefoneException(e);
            }
        else
            throw new TelefoneException(new Exception("Telefone já está cadastrado no sistema"));
    }
    /*atenção ao atualizar!!
    TENHA CERTEZA QUE ESTE CONTATO JÁ EXISTE NO BD OU ENTÃO HAVERÁ DUPLICIDADE
    */
    public void designar(Telefone telefone) {
            telefone.setDisponivel(false);
            telefoneRepository.save(telefone);
    }
    public void destituir(Telefone telefone){
        telefone.setDisponivel(true);
        telefoneRepository.save(telefone);
    }
    public void atualizar(Telefone telefone){
        telefoneRepository.save(telefone);
    }
    @Transactional
    public void remover(Telefone telefone){
        telefoneRepository.delete(telefone);
    }
    public void removerTodos(){
        telefoneRepository.deleteAll();
    }
    @Transactional
    public Optional<Telefone> encontrarPorId(long id){
        return telefoneRepository.findById(id);
    }

    public Optional<Telefone> encontrarPorNumero(String numero){
        return telefoneRepository.findByNumero(numero);
    }
    public Optional<Telefone> encontrarPorRamal(String ramal){
        return telefoneRepository.findByRamal(ramal);
    }
}
