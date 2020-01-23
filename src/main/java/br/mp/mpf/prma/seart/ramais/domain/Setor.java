package br.mp.mpf.prma.seart.ramais.domain;

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

    @OneToOne
    @JoinColumn(name= "telefone_id")
    private Telefone telefone;
    @ManyToOne
    @JoinColumn(name="contato_id")
    private List<Contato> contatos;

    public Setor(String nome, Telefone telefone) {
        this.nome = nome;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setor setor = (Setor) o;
        return id == setor.id &&
                nome.equals(setor.nome) &&
                Objects.equals(telefone, setor.telefone) &&
                Objects.equals(contatos, setor.contatos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, contatos);
    }
}
