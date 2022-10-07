package br.com.biblioteca.ApiBibliotecaServices.service;

import br.com.biblioteca.ApiBibliotecaServices.dto.LivroRequestDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.LivroResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Livro;

import java.util.List;

public interface LivroService {

    List<LivroResponseDto> getTodosLivros();

    LivroResponseDto getLivroById(Long id);

    LivroResponseDto addLivro(LivroRequestDto livroRequestDto);

    LivroResponseDto updateLivro(Long id, LivroRequestDto livroRequestDto);

    void deleteLivro(Long id);

}
