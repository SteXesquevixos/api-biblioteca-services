package br.com.biblioteca.ApiBibliotecaServices.controller;

import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteRequestDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Estudante;
import br.com.biblioteca.ApiBibliotecaServices.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @RequestMapping(value = "/estudantes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estudante>> getTodosEstudantes() {

        List<Estudante> estudantes = estudanteService.getTodosEstudantes();
        return ResponseEntity.ok(estudantes);
    }

    @RequestMapping(value = "/estudantes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstudanteResponseDto> getEstudanteById(@PathVariable(name = "id") Long id) {

        EstudanteResponseDto estudanteResponseDto = estudanteService.getEstudanteById(id);
        return new ResponseEntity(estudanteResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/estudantes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstudanteResponseDto> addEstudante(@RequestBody EstudanteRequestDto estudanteRequestDto) {

        EstudanteResponseDto estudanteResponseDto = estudanteService.addEstudante(estudanteRequestDto);
        return new ResponseEntity(estudanteResponseDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/estudantes/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstudanteResponseDto> updateEstudante(@PathVariable(name = "id") Long id, @RequestBody EstudanteRequestDto estudanteRequestDto) {

        EstudanteResponseDto estudanteResponseDto = estudanteService.updateEstudante(id, estudanteRequestDto);
        return new ResponseEntity<>(estudanteResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/estudantes/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteEstudante(@PathVariable(name = "id") Long id) {

        estudanteService.deleteEstudante(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
