package service.impl;

import dtos.AutoDTO;
import dtos.OpcionDTO;
import entities.Auto;
import entities.Opcion;
import exception.RepositoryException;
import exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.IAutoRepository;
import service.IAutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/
public class AutoService implements IAutoService {

    @Autowired
    private IAutoRepository autoRepository;
    private AutoDTO auto;


    /**
     *
     * @param opcionalesDTO
     * @throws ServiceException
     */
    @Override
    public void agregarOpcionales(List<OpcionDTO> opcionalesDTO) throws ServiceException{
        try {
            List<Opcion> opcionales = new ArrayList<>();
            for (int i = 0; i < opcionalesDTO.size(); i++) {
                opcionales.add(converter(opcionalesDTO.get(i)));
            }
            this.auto.setOpcionales(opcionales);

        }catch (Exception ex) {
            throw new ServiceException("Error: Clase AutoService método agregarOpcionales" + ex.getCause());
        }


    }

    /**
     *
     * @return
     * @throws ServiceException
     */
    @Override
    public Integer calcularPrecioFinal() throws ServiceException {
        try {
            Integer precioOpcionales = calcularPrecioTotalDeOpcionales();
            Integer precioVariante = this.auto.getVariante().getPrecio();
            Integer total = precioOpcionales + precioVariante;

            return total;
        }catch (Exception ex) {
            throw new ServiceException("Error: Clase AutoService método calcularPrecioFinal" + ex.getCause());

        }
    }

    /**
     *
     * @return
     * @throws ServiceException
     */
    @Override
    public Integer calcularPrecioTotalDeOpcionales() throws ServiceException{

        try {
            Integer precioTotal = 0;
            if (!this.auto.getOpcionales().isEmpty()) {
                for (int i = 0; i < this.auto.getOpcionales().size(); i++) {
                    precioTotal = precioTotal + this.auto.getOpcionales().get(i).getPrecio();
                }
            }
            return precioTotal;
        }catch (Exception ex) {
            throw new ServiceException("Error: Clase AutoService método calcularPrecioTotalDeOpcionales" + ex.getCause());

        }

    }


    /**
     *
     * @return
     * @throws ServiceException
     */
    @Override
    public List<AutoDTO> consultarAutos() throws ServiceException {
        try {
            List<AutoDTO> autosDTO = new ArrayList<>();
            List<Auto> autos = (List<Auto>) this.autoRepository.findAll();
            for (Auto auto: autos) {
                autosDTO.add(converter(auto));
            }
            return autosDTO;

        }catch (Exception ex) {
            throw new ServiceException("Error: Clase AutoService método consultaAutos" + ex.getCause());
        }

    }

    /**
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public AutoDTO consultarAuto(Integer id) throws ServiceException {

        try {
            Optional<Auto> entityOptional = this.autoRepository.findById(id);
            return converter(entityOptional.get());
        }catch (Exception ex) {
            throw new ServiceException("Error: Clase AutoService método consultarAuto" + ex.getCause());
        }
    }

    /**
     *
     * @param id
     * @throws ServiceException
     */
    @Override
    public void eliminarAuto(Integer id) throws ServiceException{
        try {
            this.autoRepository.deleteById(id);
        } catch (Exception ex) {
            throw new ServiceException("Error: Clase AutoService método eliminarAuto" + ex.getCause());
        }
    }


    private Opcion converter(OpcionDTO opcionDto)  {

        Opcion opcion = new Opcion();

        opcion.setId(opcionDto.getId());
        opcion.setDescripcion(opcionDto.getDescripcion());
        opcion.setPrecio(opcionDto.getPrecio());

        return opcion;
    }

    private Auto converter(AutoDTO autoDTO) {

        Auto auto = new Auto();

        auto.setPrecioFinal(autoDTO.getPrecioFinal());
        auto.setId(autoDTO.getId());
        auto.setNroOpciones(autoDTO.getOpcionales().size());
        auto.setOpcionales(autoDTO.getOpcionales());
        auto.setVariante(autoDTO.getVariante());
        return auto;


    }

    private AutoDTO converter(Auto auto) {

        AutoDTO autoDTO = new AutoDTO();
        autoDTO.setPrecioFinal(auto.getPrecioFinal());
        autoDTO.setId(auto.getId());
        autoDTO.setOpcionales(auto.getOpcionales());
        autoDTO.setNroOpciones(auto.getOpcionales().size());
        auto.setVariante(auto.getVariante());

        return autoDTO;
    }
}
