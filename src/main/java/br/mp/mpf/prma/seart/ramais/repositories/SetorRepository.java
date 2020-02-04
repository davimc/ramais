package br.mp.mpf.prma.seart.ramais.repositories;

import br.mp.mpf.prma.seart.ramais.domain.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

   /* @Query("SELECT * FROM setor s WHERE nome = %?1%")
    public List<Setor> findByNome(String nome);*/
    public Optional<Setor> findByNome(String nome);
}
