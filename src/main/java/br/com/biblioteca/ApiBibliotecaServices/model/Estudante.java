package br.com.biblioteca.ApiBibliotecaServices.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estudantes")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "curso", nullable = false)
    private String curso;

    @Column(name = "numero_matricula", nullable = false)
    private Long numeroMatricula;

    @OneToOne(mappedBy = "estudante")
    private Livro livro;

}
