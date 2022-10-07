package br.com.biblioteca.ApiBibliotecaServices.service.impl;

import br.com.biblioteca.ApiBibliotecaServices.coverter.ListLivroToListLivroResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.coverter.LivroToLivroResponseDto;
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

    @Autowired
    private ListLivroToListLivroResponseDto listLivroToListLivroResponseDto;

    @Autowired
    private LivroToLivroResponseDto livroToLivroResponseDto;

    public List<LivroResponseDto> getTodosLivros() {
        List<Livro> livros = livroRepository.findAll();
        return listLivroToListLivroResponseDto.convert(livros);
    }

    @Override
    public LivroResponseDto getLivroById(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livroToLivroResponseDto.convert(livro.get());
    }

    public LivroResponseDto addLivro(LivroRequestDto livroRequestDto) {

        Livro livro = new Livro();
        livro.setNome(livroRequestDto.getNome());
        livro.setAutor(livroRequestDto.getAutor());
        livro.setEdicao(livroRequestDto.getEdicao());
        livro.setVolume(livroRequestDto.getVolume());
        livro.setDescricao(livroRequestDto.getDescricao());
//        livro.setEstudante(livroRequestDto.getEstudante());

        Livro livroSaved = livroRepository.save(livro);

        return livroToLivroResponseDto.convert(livroSaved);
    }

    public LivroResponseDto updateLivro(Long id, LivroRequestDto livroRequestDto) {

        Livro livro = livroRepository.findById(id).get();

        livro.setNome(livroRequestDto.getNome());
        livro.setAutor(livroRequestDto.getAutor());
        livro.setEdicao(livroRequestDto.getEdicao());
        livro.setVolume(livroRequestDto.getVolume());
        livro.setDescricao(livroRequestDto.getDescricao());
//        livro.setEstudante(livroRequestDto.getEstudante());

        Livro livroSaved = livroRepository.save(livro);

        return livroToLivroResponseDto.convert(livroSaved);
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

}