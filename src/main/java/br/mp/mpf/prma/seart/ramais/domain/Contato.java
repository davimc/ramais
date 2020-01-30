package br.mp.mpf.prma.seart.ramais.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    //pegar foto
    @NotEmpty(message = "O contato precisa de um nome")
    private String nome;

    @OneToOne
    private Telefone telefone;
    @ManyToOne
    @JoinColumn(name="setor_id")
    @JsonManagedReference
    private Setor setor;

    public Contato() {
    }

    public Contato(@NotEmpty(message = "O contato precisa de um nome") String nome, @NotNull(message = "O contato precisa de um setor") Setor setor) {
        this.nome = nome;
        this.setor = setor;
    }

    public Contato(@NotEmpty(message = "O contato precisa de um nome") String nome, Telefone telefone, @NotNull(message = "O contato precisa de um setor") Setor setor) {
        this.nome = nome;
        this.telefone = telefone;
        this.setor = setor;
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

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }


    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
