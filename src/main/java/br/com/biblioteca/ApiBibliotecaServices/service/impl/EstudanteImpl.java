package br.com.biblioteca.ApiBibliotecaServices.service.impl;

import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteRequestDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Estudante;
import br.com.biblioteca.ApiBibliotecaServices.repository.EstudanteRepository;
import br.com.biblioteca.ApiBibliotecaServices.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteImpl implements EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> getTodosEstudantes() {
        return estudanteRepository.findAll();
    }

    @Override
    public EstudanteResponseDto getEstudanteById(Long id) {

        EstudanteResponseDto estudanteResponseDto = new EstudanteResponseDto();
        Optional<Estudante> estudante = estudanteRepository.findById(id);

        if (estudante.isPresent()) {
            estudanteResponseDto.setId(estudante.get().getId());
            estudanteResponseDto.setNome(estudante.get().getNome());
            estudanteResponseDto.setCurso(estudante.get().getCurso());
            estudanteResponseDto.setNumeroMatricula(estudante.get().getNumeroMatricula());
        }

        return estudanteResponseDto;
    }

    public EstudanteResponseDto addEstudante(EstudanteRequestDto estudanteRequestDto) {

        Estudante estudante = new Estudante();
        estudante.setNome(estudanteRequestDto.getNome());
        estudante.setCurso(estudanteRequestDto.getCurso());
        estudante.setNumeroMatricula(estudanteRequestDto.getNumeroMatricula());

        Estudante estudanteSaved = estudanteRepository.save(estudante);

        EstudanteResponseDto estudanteResponseDto = new EstudanteResponseDto();
        estudanteResponseDto.setId(estudanteSaved.getId());
        estudanteResponseDto.setNome(estudanteSaved.getNome());
        estudanteResponseDto.setCurso(estudanteSaved.getCurso());
        estudanteResponseDto.setNumeroMatricula(estudanteSaved.getNumeroMatricula());

        return estudanteResponseDto;
    }

    public EstudanteResponseDto updateEstudante(Long id, EstudanteRequestDto estudanteRequestDto) {

        Estudante estudante = estudanteRepository.findById(id).get();

        estudante.setNome(estudanteRequestDto.getNome());
        estudante.setCurso(estudanteRequestDto.getCurso());
        estudante.setNumeroMatricula(estudanteRequestDto.getNumeroMatricula());

        Estudante estudanteSaved = estudanteRepository.save(estudante);

        EstudanteResponseDto estudanteResponseDto = new EstudanteResponseDto();
        estudanteResponseDto.setId(estudanteSaved.getId());
        estudanteResponseDto.setNome(estudanteSaved.getNome());
        estudanteResponseDto.setCurso(estudanteSaved.getCurso());
        estudanteResponseDto.setNumeroMatricula(estudanteSaved.getNumeroMatricula());

        return estudanteResponseDto;
    }

    public void deleteEstudante(Long id) {
        estudanteRepository.deleteById(id);
    }

}
