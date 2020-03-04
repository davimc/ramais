package br.mp.mpf.prma.seart.ramais.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotEmpty(message = "O setor precisa ter um nome")
    private String nome;
    private int numero;

    @OneToOne
    @JoinColumn(name= "id_telefone")
    private Telefone telefone;
    @OneToMany(mappedBy = "setor")
    @JsonBackReference
    private List<Contato> contatos;

    public Setor() {
    }

    public Setor(String nome, int numero, Telefone telefone) {
        this.nome = nome;
        this.numero = numero;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }



    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void adicionaContato(Contato contato) {
        this.contatos.add(contato);
    }
    public void removeContato(Contato contato){
        this.contatos.remove(contato);
    }

}
