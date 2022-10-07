package br.com.biblioteca.ApiBibliotecaServices.coverter;

import br.com.biblioteca.ApiBibliotecaServices.dto.LivroResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LivroToLivroResponseDto implements Converter<Livro, LivroResponseDto> {

    @Autowired
    private EstudanteToEstudanteResponseDto estudanteToEstudanteResponseDto;

    @Override
    public LivroResponseDto convert(Livro livro) {
        return LivroResponseDto.builder()
                .id(livro.getId())
                .nome(livro.getNome())
                .descricao(livro.getDescricao())
                .edicao(livro.getEdicao())
                .volume(livro.getVolume())
                .autor(livro.getAutor())
                .estudante(estudanteToEstudanteResponseDto.convert(livro.getEstudante()))
                .build();
    }
}
