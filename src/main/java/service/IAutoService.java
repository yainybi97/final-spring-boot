package service;

import dtos.AutoDTO;
import dtos.OpcionDTO;
import entities.Auto;
import exception.ServiceException;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/

@RestController
public interface IAutoService {

    public Integer calcularPrecioFinal() throws ServiceException;

    public Integer calcularPrecioTotalDeOpcionales() throws ServiceException;

    public List<AutoDTO> consultarAutos() throws ServiceException;

    public AutoDTO consultarAuto(Integer id) throws ServiceException;

    public void eliminarAuto(Integer id) throws ServiceException;

    public void agregarOpcionales(List<OpcionDTO> opcionalesDTO) throws ServiceException;



}


