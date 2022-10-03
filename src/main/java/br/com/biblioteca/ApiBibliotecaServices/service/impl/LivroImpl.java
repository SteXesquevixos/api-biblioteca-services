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
            livroResponseDto.setAutor(livro.get().getAutor());
            livroResponseDto.setEdicao(livro.get().getEdicao());
            livroResponseDto.setVolume(livro.get().getVolume());
            livroResponseDto.setDescricao(livro.get().getDescricao());
            livroResponseDto.setEstudante(livro.get().getEstudante());
        }

        return livroResponseDto;
    }

    public LivroResponseDto addLivro(LivroRequestDto livroRequestDto) {

        Livro livro = new Livro();
        livro.setNome(livroRequestDto.getNome());
        livro.setAutor(livroRequestDto.getAutor());
        livro.setEdicao(livroRequestDto.getEdicao());
        livro.setVolume(livroRequestDto.getVolume());
        livro.setDescricao(livroRequestDto.getDescricao());
        livro.setEstudante(livroRequestDto.getEstudante());

        Livro livroSaved = livroRepository.save(livro);

        LivroResponseDto livroResponseDto = new LivroResponseDto();
        livroResponseDto.setId(livroSaved.getId());
        livroResponseDto.setNome(livroSaved.getNome());
        livroResponseDto.setAutor(livroSaved.getAutor());
        livroResponseDto.setEdicao(livroSaved.getEdicao());
        livroResponseDto.setVolume(livroSaved.getVolume());
        livroResponseDto.setDescricao(livroSaved.getDescricao());
        livroResponseDto.setEstudante(livroSaved.getEstudante());

        return livroResponseDto;
    }

    public LivroResponseDto updateLivro(Long id, LivroRequestDto livroRequestDto) {

        Livro livro = livroRepository.findById(id).get();

        livro.setNome(livroRequestDto.getNome());
        livro.setAutor(livroRequestDto.getAutor());
        livro.setEdicao(livroRequestDto.getEdicao());
        livro.setVolume(livroRequestDto.getVolume());
        livro.setDescricao(livroRequestDto.getDescricao());
        livro.setEstudante(livroRequestDto.getEstudante());

        Livro livroSaved = livroRepository.save(livro);

        LivroResponseDto livroResponseDto = new LivroResponseDto();
        livroResponseDto.setId(livroSaved.getId());
        livroResponseDto.setNome(livroSaved.getNome());
        livroResponseDto.setAutor(livroSaved.getAutor());
        livroResponseDto.setEdicao(livroSaved.getEdicao());
        livroResponseDto.setVolume(livroSaved.getVolume());
        livroResponseDto.setDescricao(livroSaved.getDescricao());
        livroResponseDto.setEstudante(livroSaved.getEstudante());

        return livroResponseDto;
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

}