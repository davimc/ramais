package br.mp.mpf.prma.seart.ramais.contatoTestes;

import br.mp.mpf.prma.seart.ramais.RamaisApplication;
import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.domain.Setor;
import br.mp.mpf.prma.seart.ramais.domain.Telefone;


import br.mp.mpf.prma.seart.ramais.services.ContatoService;
import br.mp.mpf.prma.seart.ramais.services.SetorService;
import br.mp.mpf.prma.seart.ramais.services.TelefoneService;
import br.mp.mpf.prma.seart.ramais.services.exceptions.ContatoException;
import br.mp.mpf.prma.seart.ramais.services.exceptions.SetorException;
import br.mp.mpf.prma.seart.ramais.services.exceptions.TelefoneException;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.validation.Validator;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= RamaisApplication.class)
public class ContatoServiceIntegrationTest {
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private SetorService setorService;
    @Autowired
    private TelefoneService telefoneService;

    private Contato contato;
    private Setor setor;
    private Telefone telefoneSetor;
    private Telefone telefoneContato;

    private Validator validator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Before
    public void start(){
        telefoneSetor =new Telefone("98027400");
        telefoneContato = new Telefone("98027401");

        try{
            telefoneService.inserir(telefoneSetor);
            telefoneService.inserir(telefoneContato);
        }catch(TelefoneException e){
            e.getMessage();
        }
        setor = new Setor("SEART", telefoneSetor);


        setor.setContatos(Arrays.asList(contato));
        try{
            setorService.inserir(setor);
        }catch(SetorException e){
            e.getMessage();
        }
        contato = new Contato("Davi", telefoneContato, setor);

    }

    @Test
    public void testaNomeNuloDeveLancarExcecao() throws Exception{
        expectedException.expect((ContatoException.class));
        expectedException.expectMessage("O contato precisa de um nome");
        contato.setNome("");
        try {
            contatoService.inserir(contato);
        }catch(ContatoException e){
            e.getMessage();
        }
    }

}
