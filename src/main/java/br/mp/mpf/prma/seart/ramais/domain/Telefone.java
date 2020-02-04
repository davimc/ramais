package br.mp.mpf.prma.seart.ramais.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O telefone nao pode ser salvo sem numero")
    private String numero;
    private String ramal;
    @Column(name="disponivel")
    private boolean isDisponivel;

    public Telefone() {
    }



    public Telefone( String numero) {
        this.numero = numero;
        this.ramal = geraRamal();
        isDisponivel = true;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
        this.ramal = geraRamal();
    }

    public String getRamal() {
        return ramal;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    private String geraRamal(){
        return numero.substring(numero.length()-4);
    }
}
