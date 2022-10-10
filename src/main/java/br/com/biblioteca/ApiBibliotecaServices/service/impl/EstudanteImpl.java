package br.com.biblioteca.ApiBibliotecaServices.service.impl;

import br.com.biblioteca.ApiBibliotecaServices.coverter.EstudanteToEstudanteResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.coverter.ListEstudanteToListEstudanteResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteRequestDto;
import br.com.biblioteca.ApiBibliotecaServices.dto.EstudanteResponseDto;
import br.com.biblioteca.ApiBibliotecaServices.model.Estudante;
import br.com.biblioteca.ApiBibliotecaServices.repository.EstudanteRepository;
import br.com.biblioteca.ApiBibliotecaServices.service.EstudanteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteImpl implements EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private ListEstudanteToListEstudanteResponseDto listEstudanteToListEstudanteResponseDto;


    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private EstudanteToEstudanteResponseDto estudanteToEstudanteResponseDto;

    public List<EstudanteResponseDto> getTodosEstudantes() {
        List<Estudante> estudantes = estudanteRepository.findAll();
        return listEstudanteToListEstudanteResponseDto.convert(estudantes);
    }

    @Override
    public EstudanteResponseDto getEstudanteById(Long id) {
        Optional<Estudante> estudante = estudanteRepository.findById(id);
        return estudanteToEstudanteResponseDto.convert(estudante.get());
    }

    public EstudanteResponseDto addEstudante(EstudanteRequestDto estudanteRequestDto) {

//        Estudante estudante = new Estudante();
//        estudante.setNome(estudanteRequestDto.getNome());
//        estudante.setCurso(estudanteRequestDto.getCurso());
//        estudante.setNumeroMatricula(estudanteRequestDto.getNumeroMatricula());

        Estudante estudante =  modelMapper.map(estudanteRequestDto, Estudante.class);

        Estudante estudanteSaved = estudanteRepository.save(estudante);

        return estudanteToEstudanteResponseDto.convert(estudanteSaved);
    }

    public EstudanteResponseDto updateEstudante(Long id, EstudanteRequestDto estudanteRequestDto) {

        Estudante estudante = estudanteRepository.findById(id).get();

        estudante.setNome(estudanteRequestDto.getNome());
        estudante.setCurso(estudanteRequestDto.getCurso());
        estudante.setNumeroMatricula(estudanteRequestDto.getNumeroMatricula());

        Estudante estudanteSaved = estudanteRepository.save(estudante);

        return estudanteToEstudanteResponseDto.convert(estudanteSaved);
    }

    public void deleteEstudante(Long id) {
        estudanteRepository.deleteById(id);
    }

}
