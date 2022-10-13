package br.com.biblioteca.ApiBibliotecaServices.coverter;

import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.LivroResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Estudante;
import br.com.biblioteca.ApiBibliotecaServices.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstudanteToEstudanteResponseDto implements Converter<Estudante, EstudanteResponseDto> {

    @Override
    public EstudanteResponseDto convert(Estudante estudante) {
        return EstudanteResponseDto.builder()
                .id(estudante.getId())
                .nome(estudante.getNome())
                .curso(estudante.getCurso())
                .numeroMatricula(estudante.getNumeroMatricula())
//                .livro(estudante.getLivro() != null ?
//                        LivroResponseDto.builder()
//                                .id(estudante.getLivro().getId())
//                                .nome(estudante.getLivro().getNome())
//                                .descricao(estudante.getLivro().getDescricao())
//                                .edicao(estudante.getLivro().getEdicao())
//                                .volume(estudante.getLivro().getVolume())
//                                .autor(estudante.getLivro().getAutor())
//                                .build()
//                        : null)
                .build();
    }
}
