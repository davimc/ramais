package br.mp.mpf.prma.seart.ramais.repositories;

import br.mp.mpf.prma.seart.ramais.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
    @Query("SELECT * FROM contato c WHERE nome = %?1%")
    public List<Contato> findByNome(String nome);
    @Query("SELECT c FROM contato c WHERE telefone_id = ?")
    public Contato findByTelefone(long telefoneId);
}
