package repositories;

import entities.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 7/11/20
 **/

@Repository
public interface IOpcionRepository extends JpaRepository<Opcion, Integer> {
}
