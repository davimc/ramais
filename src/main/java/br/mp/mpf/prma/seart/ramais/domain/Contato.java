package br.mp.mpf.prma.seart.ramais.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
public class Contato {
    /*Necessáiro de modificar Contato e Setor para herdar
     *de uma class abstrata e adicionar id correspondente
     * no telefone
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    //pegar foto
    @NotEmpty(message = "O contato precisa de um nome")
    private String nome;
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_telefone")
    private Telefone telefone;
    @ManyToOne
    @JoinColumn(name="id_setor")
    @JsonManagedReference
    private Setor setor;

    public Contato() {
    }

    public Contato(@NotEmpty(message = "O contato precisa de um nome") String nome, String email,  Setor setor) {
        this.nome = nome;
        this.setor = setor;
        this.email = email;
    }

    public Contato(@NotEmpty(message = "O contato precisa de um nome") String nome, String email, Telefone telefone,  Setor setor) {
        this.nome = nome;
        this.telefone = telefone;
        this.setor = setor;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
