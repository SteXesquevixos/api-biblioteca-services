package br.com.biblioteca.ApiBibliotecaServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteRequestDto {

    private String nome;

    private String curso;

    private Long numeroMatricula;

//    private LivroResponseDto livro;

}
