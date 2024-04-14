package br.com.fiap.agroclimate.repository;

import br.com.fiap.agroclimate.model.Clima;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimaRepository extends JpaRepository<Clima, Long> {
}
