package service;

import dtos.OpcionDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/

@RestController
public interface IOpcionalService {

    public List<OpcionDTO> consultarOpcions();

    public OpcionDTO consultarOpcion(Integer id);

    public void eliminarOpcion(Integer id);
}
