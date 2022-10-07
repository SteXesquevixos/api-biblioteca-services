package br.com.biblioteca.ApiBibliotecaServices.coverter;

import br.com.biblioteca.ApiBibliotecaServices.dto.LivroResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListLivroToListLivroResponseDto implements Converter<List<Livro>, List<LivroResponseDto>> {

    @Autowired
    private EstudanteToEstudanteResponseDto estudanteToEstudanteResponseDto;

    @Override
    public List<LivroResponseDto> convert(List<Livro> livros) {
        return livros.stream().map(livro -> LivroResponseDto.builder()
                        .id(livro.getId())
                        .nome(livro.getNome())
                        .autor(livro.getAutor())
                        .edicao(livro.getEdicao())
                        .volume(livro.getVolume())
                        .descricao(livro.getDescricao())
                        .estudante(estudanteToEstudanteResponseDto.convert(livro.getEstudante()))
                        .build())
                .collect(Collectors.toList());
    }

}
