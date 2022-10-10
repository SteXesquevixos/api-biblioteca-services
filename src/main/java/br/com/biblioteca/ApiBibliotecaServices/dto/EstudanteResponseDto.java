package br.com.biblioteca.ApiBibliotecaServices.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudanteResponseDto {

    private Long id;

    private String nome;

    private String curso;

    private Long numeroMatricula;

    private LivroResponseDto livro;
}
