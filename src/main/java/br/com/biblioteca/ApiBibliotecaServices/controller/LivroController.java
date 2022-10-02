package br.com.biblioteca.ApiBibliotecaServices.controller;

import br.com.biblioteca.ApiBibliotecaServices.dto.LivroRequestDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.LivroResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Livro;
import br.com.biblioteca.ApiBibliotecaServices.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @RequestMapping(value = "/livros", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Livro>> getTodosLivros() {

        List<Livro> livros = livroService.getTodosLivros();
        return ResponseEntity.ok(livros);
    }

    @RequestMapping(value = "/livros/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponseDto> getLivroById(@PathVariable(name = "id") Long id) {

        LivroResponseDto livroResponseDto = livroService.getLivroById(id);
        return new ResponseEntity(livroResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/livros", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponseDto> addLivro(@RequestBody LivroRequestDto livroRequestDto) {

        LivroResponseDto livroResponseDto = livroService.addLivro(livroRequestDto);
        return new ResponseEntity(livroResponseDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/livros/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponseDto> updateLivro(@PathVariable(name = "id") Long id, @RequestBody LivroRequestDto livroRequestDto) {

        LivroResponseDto livroResponseDto = livroService.updateLivro(id, livroRequestDto);
        return new ResponseEntity<>(livroResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/livros/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteLivro(@PathVariable(name = "id") Long id) {

        livroService.deleteLivro(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
