package br.mp.mpf.prma.seart.ramais.repositories;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
    @Query("SELECT * FROM contato c WHERE nome = %?1%")
    public Optional<Contato> retornaContatosPorNome(String nome);

}
