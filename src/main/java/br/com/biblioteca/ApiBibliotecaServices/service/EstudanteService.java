package br.com.biblioteca.ApiBibliotecaServices.service;

import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteRequestDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Estudante;

import java.util.List;

public interface EstudanteService {

    List<EstudanteResponseDto> getTodosEstudantes();

    EstudanteResponseDto getEstudanteById(Long id);

    EstudanteResponseDto addEstudante(EstudanteRequestDto estudanteRequestDto);

    EstudanteResponseDto updateEstudante(Long id, EstudanteRequestDto estudanteRequestDto);

    void deleteEstudante(Long id);

}
