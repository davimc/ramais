package br.mp.mpf.prma.seart.ramais.services;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.domain.Setor;
import br.mp.mpf.prma.seart.ramais.domain.Telefone;
import br.mp.mpf.prma.seart.ramais.repositories.ContatoRepository;
import br.mp.mpf.prma.seart.ramais.services.exceptions.ContatoException;
import br.mp.mpf.prma.seart.ramais.services.exceptions.SetorException;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import br.mp.mpf.prma.seart.ramais.services.forms.ContatoForm;
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
    @Autowired
    SetorService setorService;

    public void inserir(Contato contato) throws ContatoException, TelefoneException {
        /*ifs:
        * primeiro testa se o setor e telefone existem
        * testa se o telefone está disponível para o contato
        * */
        Optional<Telefone> telefone = telefoneService.encontrarPorRamal(contato.getTelefone().getNumero());
        Optional<Setor> setor = setorService.encontraPorNome(contato.getSetor().getNome());
        if( telefone.isPresent() && setor.isPresent()) {
            if(telefone.get().isDisponivel()) {
                telefone.get().setDisponivel(false);
                setor.get().adicionaContato(contato);
                try {
                    telefoneService.designar(telefone.get());
                    contatoRepository.save(contato);
                    setorService.atualizar(setor.get());
                } catch (ConstraintViolationException e) {
                    throw new ContatoException(e);
                }

            } else {
                throw new TelefoneException(new Exception("Telefone em uso"));
            }
        }else
            throw new ContatoException(new Exception("Verifique o setor ou ramal"));
    }
    public void atualizar(Contato contatoAntigo, ContatoForm contatoAtualizado) {
        if(contatoAntigo.getTelefone()!=null) {
            if (contatoAntigo.getTelefone().getNumero() != contatoAtualizado.getTelefone()) {
                Telefone telefoneAntigo = telefoneService.encontrarPorNumero(contatoAntigo.getTelefone().getNumero()).get();
                Telefone telefoneAtual = telefoneService.encontrarPorNumero(contatoAtualizado.getTelefone()).get();
                telefoneService.destituir(telefoneAntigo);
                telefoneService.designar(telefoneAtual);
                contatoAntigo.setTelefone(telefoneAtual);
            }
        } else{
            telefoneService.designar(telefoneService.encontrarPorNumero(contatoAtualizado.getTelefone()).get());
            contatoAntigo.setTelefone(telefoneService.encontrarPorNumero(contatoAtualizado.getTelefone()).get());
        }
        if(contatoAntigo.getSetor().getNome()!=contatoAtualizado.getNomeSetor()) {
            Setor setorAntigo = setorService.encontraPorNome(contatoAntigo.getSetor().getNome()).get();
            Setor setorAtualizado = setorService.encontraPorNome(contatoAtualizado.getNomeSetor()).get();
            setorAntigo.removeContato(contatoAntigo);
            setorAtualizado.adicionaContato(contatoRepository.findByNome(contatoAtualizado.getNomeContato()).get());
            contatoAntigo.setSetor(setorAtualizado);
        }
    }

    public Optional<Contato> buscarPorNome(String nome){
        return contatoRepository.findByNome(nome);
    }
    public Optional<Contato> buscarPorRamal(String ramal){
        return contatoRepository.findByTelefoneRamal(ramal);
    }
    public void remover(Contato contato){
        contatoRepository.delete(contato);
    }

    public List<Contato> listaTodosContatos(){
        return contatoRepository.findAll();
    }
}
