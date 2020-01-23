package br.mp.mpf.prma.seart.ramais.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotEmpty(message = "O telefone não pode ser salvo sem número")
    private String numero;
    @NotEmpty(message="O telefone não pode ser salvo sem um ramal")
    private String ramal;


    public Telefone(String numero) {
        this.numero = numero;
        this.ramal = geraRamal();
    }

    public long getId() {
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
