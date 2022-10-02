package br.com.biblioteca.ApiBibliotecaServices.service.impl;

import br.com.biblioteca.ApiBibliotecaServices.dto.LivroRequestDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.LivroResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Livro;
import br.com.biblioteca.ApiBibliotecaServices.repository.LivroRepository;
import br.com.biblioteca.ApiBibliotecaServices.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getTodosLivros() {
        return livroRepository.findAll();
    }

    @Override
    public LivroResponseDto getLivroById(Long id) {

        LivroResponseDto livroResponseDto = new LivroResponseDto();
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isPresent()) {
            livroResponseDto.setId(livro.get().getId());
            livroResponseDto.setNome(livro.get().getNome());
            livroResponseDto.setDescricao(livro.get().getDescricao());
        }

        return livroResponseDto;
    }

    public LivroResponseDto addLivro(LivroRequestDto livroRequestDto) {

        Livro livro = new Livro();
        livro.setNome(livroRequestDto.getNome());
        livro.setDescricao(livroRequestDto.getDescricao());

        Livro livroSaved = livroRepository.save(livro);

        LivroResponseDto livroResponseDto = new LivroResponseDto();
        livroResponseDto.setId(livroSaved.getId());
        livroResponseDto.setNome(livroSaved.getNome());
        livroResponseDto.setDescricao(livroSaved.getDescricao());

        return livroResponseDto;
    }

    public LivroResponseDto updateLivro(Long id, LivroRequestDto livroRequestDto) {

        Livro livro = livroRepository.findById(id).get();

        livro.setNome(livroRequestDto.getNome());
        livro.setDescricao(livroRequestDto.getDescricao());

        Livro livroSaved = livroRepository.save(livro);

        LivroResponseDto livroResponseDto = new LivroResponseDto();
        livroResponseDto.setId(livroSaved.getId());
        livroResponseDto.setNome(livroSaved.getNome());
        livroResponseDto.setDescricao(livroSaved.getDescricao());

        return livroResponseDto;
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

}