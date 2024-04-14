package br.com.fiap.agroclimate.repository;

import br.com.fiap.agroclimate.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
}

