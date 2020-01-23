package br.mp.mpf.prma.seart.ramais.contatoTestes;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import br.mp.mpf.prma.seart.ramais.repositories.ContatoRepository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ContatoServiceIntegrationTest {
    @Autowired
    private ContatoRepository contatoRepository;

    private Contato contato;

    @Before
    public void start(){
        contato = new Contato();
    }

    @Test
    public void testaNomeNuloDeveLancarExcecao(){

    }

}
