package br.mp.mpf.prma.seart.ramais.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O telefone nao pode ser salvo sem numero")
    private String numero;
    private String ramal = "4444";

    public Telefone() {
    }



    public Telefone( String numero) {

        this.numero = numero;
        if(!numero.isEmpty())
            this.ramal = geraRamal();
        else
            ramal = "4444";

    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }


    private String geraRamal(){

        return numero.substring(numero.length()-4);
    }
}
