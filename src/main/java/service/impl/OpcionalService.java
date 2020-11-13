package service.impl;

import dtos.OpcionDTO;
import entities.Opcion;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.IOpcionRepository;
import service.IOpcionalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/
public class OpcionalService implements IOpcionalService {

    @Autowired
    private IOpcionRepository opcionRepository;
    private OpcionDTO opcionDTO;

    @Override
    public List<OpcionDTO> consultarOpcions() {
        List<OpcionDTO> opcionsDTO = new ArrayList<>();
        List<Opcion> opcions = this.opcionRepository.findAll();
        for (Opcion opcion: opcions) {
            opcionsDTO.add(converter(opcion));
        }
        return opcionsDTO;

    }

    @Override
    public OpcionDTO consultarOpcion(Integer id) {
        Optional<Opcion> entityOptional = this.opcionRepository.findById(id);
        return converter(entityOptional.get());
    }

    @Override
    public void eliminarOpcion(Integer id) {
        this.opcionRepository.deleteById(id);
    }

    private OpcionDTO converter(Opcion opcion) {

        OpcionDTO opcionDTO = new OpcionDTO();

        opcionDTO.setId(opcion.getId());
        opcionDTO.setDescripcion(opcion.getDescripcion());
        opcionDTO.setPrecio(opcion.getPrecio());

        return opcionDTO;
    }
}
