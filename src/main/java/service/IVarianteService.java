package service;

import dtos.VarianteDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/

@RestController
public interface IVarianteService {


    public List<VarianteDTO> consultarVariantes();

    public void eliminarVariante(Integer id);

    public VarianteDTO consultarVariante(Integer id);


}
