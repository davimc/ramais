package br.mp.mpf.prma.seart.ramais.domain;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="telefone_id")
    private Telefone telefone;
    @NotNull(message = "O contato precisa de um setor")
    @OneToMany(mappedBy = "contato")
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
