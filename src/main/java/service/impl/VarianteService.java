package service.impl;

import dtos.AutoDTO;
import dtos.VarianteDTO;
import entities.Variante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repositories.IVarianteRepository;
import service.IVarianteService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/
@Component
@Service
public class VarianteService implements IVarianteService {

    @Autowired
    private IVarianteRepository varianteRepository;
    private VarianteDTO varianteDTO;


    @Override
    public List<VarianteDTO> consultarVariantes() {
        List<VarianteDTO> variantesDTO = new ArrayList<>();
        List<Variante> variantes = this.varianteRepository.findAll();
        for (Variante variante: variantes) {
            variantesDTO.add(converter(variante));
        }
        return variantesDTO;
    }

    @Override
    public VarianteDTO consultarVariante(Integer id) {
        Optional<Variante> entityOptional = this.varianteRepository.findById(id);
        return converter(entityOptional.get());
    }

    @Override
    public void eliminarVariante(Integer id) {
        this.varianteRepository.deleteById(id);
    }


    private VarianteDTO converter(Variante variante) {

        VarianteDTO varianteDTO = new VarianteDTO();
        varianteDTO.setId(variante.getId());
        varianteDTO.setDescripcion(variante.getDescripcion());
        varianteDTO.setPrecio(variante.getPrecio());

        return varianteDTO;
    }

    private Variante converter(VarianteDTO varianteDTO) {

        Variante variante = new Variante();
        variante.setId(varianteDTO.getId());
        variante.setDescripcion(varianteDTO.getDescripcion());
        variante.setPrecio(varianteDTO.getPrecio());
        return variante;
    }
}
