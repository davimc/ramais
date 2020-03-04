package br.mp.mpf.prma.seart.ramais.repositories;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
    @Query("SELECT c FROM Contato c")
    public Optional<Contato> find();
    @Query("SELECT c FROM Contato c WHERE c.nome LIKE :nome%")
    public Optional<Contato> findByNome(@Param("nome") String nome);
    public Optional<Contato> findByTelefoneRamal(String ramal);
    public Optional<Contato> findBySetor(String setor);

}
