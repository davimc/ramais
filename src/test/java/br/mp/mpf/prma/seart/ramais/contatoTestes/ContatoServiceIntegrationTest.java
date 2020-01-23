package br.mp.mpf.prma.seart.ramais.contatoTestes;

import br.mp.mpf.prma.seart.ramais.RamaisApplication;
import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.domain.Setor;
import br.mp.mpf.prma.seart.ramais.domain.Telefone;


import br.mp.mpf.prma.seart.ramais.services.ContatoService;
import br.mp.mpf.prma.seart.ramais.services.exceptions.ContatoException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.validation.Validator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= RamaisApplication.class)
public class ContatoServiceIntegrationTest {
    @Autowired
    private ContatoService contatoService;

    private Contato contato;

    private Validator validator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Before
    public void start(){
        contato = new Contato("Davi", new Telefone("98027401"),new Setor("SEART", new Telefone("98027400")));
    }

    @Test
    public void testaNomeNuloDeveLancarExcecao() throws Exception{
        expectedException.expect((ContatoException.class));
        expectedException.expectMessage("O contato precisa de um nome");
        contato.setNome(null);
        contatoService.inserir(contato);
    }

}
