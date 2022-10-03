package br.com.biblioteca.ApiBibliotecaServices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "edicao", nullable = false)
    private Integer edicao;

    @Column(name = "volume", nullable = false)
    private Integer volume;

    @Column(name = "descricao", nullable = false)
    private String descricao;

//    @Column(name = "estudante_fk", nullable = false)
    @OneToOne
    @JoinColumn(name = "estudante_fk", referencedColumnName = "id")
    private Estudante estudante;

}
