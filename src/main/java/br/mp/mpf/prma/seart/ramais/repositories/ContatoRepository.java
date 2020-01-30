package br.mp.mpf.prma.seart.ramais.repositories;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
    @Query("SELECT c FROM contato c WHERE c.nome like %?1")
    public Optional<Contato> findByNome(String nome);
    /*@Query("SELECT c FROM contato c WHERE telefone = ?1")
    public Contato findByTelefone(long telefoneId);*/
}
