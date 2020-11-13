package controller;

import dtos.AutoDTO;
import exception.ControllerException;
import exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.impl.AutoService;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/

@RestController
public class AutoController {

    @Autowired
    private AutoService autoService;

    /**
     *
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/autos", method = RequestMethod.GET, produces = "application/json")
    public List<AutoDTO> listadoAutos() throws ControllerException{
        try {
            return this.autoService.consultarAutos();

        }catch (ServiceException ex) {
            throw new ControllerException("Error: Clase AutoController método listadoAutos" + ex.getCause());
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/auto/{id}", method = RequestMethod.GET, produces = "application/json")
    public AutoDTO auto(@PathVariable Integer id) throws ControllerException {

        try {
            return this.autoService.consultarAuto(id);

        }catch (ServiceException ex) {
            throw new ControllerException("Error: Clase AutoController método auto" + ex.getCause());
        }
    }


    /**
     *
     * @param id
     * @throws ControllerException
     */

    @DeleteMapping(value = "/auto/{id}")
    public void eliminarAuto(@PathVariable Integer id) throws ControllerException {
        try {
            this.autoService.eliminarAuto(id);

        }catch (ServiceException ex) {
            throw new ControllerException("Error: Clase AutoController método eliminarauto" + ex.getCause());
        }
    }

}


