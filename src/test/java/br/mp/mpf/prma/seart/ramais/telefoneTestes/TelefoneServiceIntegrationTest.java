package br.mp.mpf.prma.seart.ramais.telefoneTestes;

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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import javax.xml.validation.Validator;
import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= RamaisApplication.class)
public class TelefoneServiceIntegrationTest {

    @Autowired
    private TelefoneService telefoneService;


    private Telefone telefone;

    private Validator validator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Before
    public void start(){
        telefone =new Telefone("98027100");




    }
    @Test
    public void testaSalvarUmTelefone(){

        try{
            telefoneService.inserir(telefone);
        }catch(TelefoneException e){
            e.getMessage();
        }
        System.out.println(telefone.getRamal());

        Assert.assertEquals(telefoneService.encontrarPorRamal(telefone.getRamal()).get().getId(), telefone.getId());
    }
    @Test
    public void testaSalvarTelefoneComNumeroJaCadastrado(){
        Telefone telefoneDuplicado = new Telefone(telefone.getNumero());
        expectedException.expect(TelefoneException.class);
        expectedException.expectMessage("Telefone já está cadastrado no sistema");
        try{
            telefoneService.inserir(telefone);
            telefoneService.inserir(telefoneDuplicado);
        }catch(TelefoneException e){
            e.getMessage();
        }
        System.out.println(telefone.getRamal());

    }
    @Test
    public void testaSalvarUmNumeroJaCadastradoDeveRetornarExcecao(){

        expectedException.expect(TelefoneException.class);
        expectedException.expectMessage("Telefone já está cadastrado no sistema");

    }
    @Test
    public void testaNumeroNuloDeveLancarExcecao() {
        expectedException.expect((TelefoneException.class));
        expectedException.expectMessage("O telefone nao pode ser salvo sem numero");
        telefone.setNumero(null);
        try {
            telefoneService.inserir(telefone);
        }catch (ConstraintViolationException e){
            e.printStackTrace();;
        }catch (TelefoneException e){
            e.printStackTrace();
        }


    }

}
