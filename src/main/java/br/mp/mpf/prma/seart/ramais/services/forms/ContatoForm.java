package br.mp.mpf.prma.seart.ramais.services.forms;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.domain.Setor;
import br.mp.mpf.prma.seart.ramais.domain.Telefone;
import br.mp.mpf.prma.seart.ramais.services.SetorService;
import br.mp.mpf.prma.seart.ramais.services.TelefoneService;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.IllegalFormatException;

public class ContatoForm {
    private String nomeContato;
    private String nomeSetor;
    private String numeroTelefone;
    @Autowired
    private SetorService setorService;
    @Autowired
    private TelefoneService telefoneService;

    public ContatoForm(String nomeContato, String nomeSetor, String numeroTelefone) {
        this.nomeContato = nomeContato;
        this.nomeSetor = nomeSetor;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getTelefone() {
        return numeroTelefone;
    }

    public void setTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
    
    public Contato converter(){
        Telefone numeroContato = telefoneService.encontraPorNumero(this.numeroTelefone).get();
        Setor setorContato = setorService.encontraPorNome(this.nomeSetor).get();
        return numeroContato!=null? new Contato(nomeContato, numeroContato, setorContato):new Contato(nomeContato,setorContato);
    }
}
