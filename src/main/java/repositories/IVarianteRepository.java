package repositories;

import entities.Variante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/

@Repository
public interface IVarianteRepository extends JpaRepository<Variante, Integer> {

}
