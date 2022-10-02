package br.com.biblioteca.ApiBibliotecaServices.repository;

import br.com.biblioteca.ApiBibliotecaServices.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
