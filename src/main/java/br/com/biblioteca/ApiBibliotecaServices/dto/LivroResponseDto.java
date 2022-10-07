package br.com.biblioteca.ApiBibliotecaServices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponseDto {

    private Long id;

    private String nome;

    private String autor;

    private Integer edicao;

    private Integer volume;

    private String descricao;

    private EstudanteResponseDto estudante;

}
