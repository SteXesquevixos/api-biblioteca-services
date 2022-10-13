package br.com.biblioteca.ApiBibliotecaServices.coverter;

import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.LivroResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Livro;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListLivroToListLivroResponseDto implements Converter<List<Livro>, List<LivroResponseDto>> {

    @Override
    public List<LivroResponseDto> convert(List<Livro> livros) {
        return livros.stream().map(livro -> LivroResponseDto.builder()
                        .id(livro.getId())
                        .nome(livro.getNome())
                        .autor(livro.getAutor())
                        .edicao(livro.getEdicao())
                        .volume(livro.getVolume())
                        .descricao(livro.getDescricao())
                        .estudante(livro.getEstudante() != null ?
                                EstudanteResponseDto.builder()
                                        .id(livro.getEstudante().getId())
                                        .nome(livro.getEstudante().getNome())
                                        .curso(livro.getEstudante().getCurso())
                                        .numeroMatricula(livro.getEstudante().getNumeroMatricula())
                                        .build()
                                : null)
                        .build())
                .collect(Collectors.toList());
    }

}
