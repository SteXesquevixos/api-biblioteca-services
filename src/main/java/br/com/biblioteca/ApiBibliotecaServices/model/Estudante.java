package br.com.biblioteca.ApiBibliotecaServices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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

}
