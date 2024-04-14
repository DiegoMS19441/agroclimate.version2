package br.com.fiap.agroclimate.repository;

import br.com.fiap.agroclimate.model.Safra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SafraRepository extends JpaRepository<Safra, Long> {
}
