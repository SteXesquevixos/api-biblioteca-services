package br.com.biblioteca.ApiBibliotecaServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroRequestDto {

    private String nome;

    private String autor;

    private Integer edicao;

    private Integer volume;

    private String descricao;

}
