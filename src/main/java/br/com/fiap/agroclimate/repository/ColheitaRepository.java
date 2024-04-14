package br.com.fiap.agroclimate.repository;

import br.com.fiap.agroclimate.model.Colheita;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ColheitaRepository extends JpaRepository<Colheita, Long> {
}
