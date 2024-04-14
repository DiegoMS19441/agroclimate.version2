package br.com.fiap.agroclimate.repository;

import br.com.fiap.agroclimate.model.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {
}
