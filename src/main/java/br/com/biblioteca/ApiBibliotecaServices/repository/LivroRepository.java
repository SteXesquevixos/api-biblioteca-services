package br.com.biblioteca.ApiBibliotecaServices.repository;

import br.com.biblioteca.ApiBibliotecaServices.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
