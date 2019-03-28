package br.pa.com.femabra.database.repository;

import br.pa.com.femabra.database.models.UserDTO;
import org.springframework.data.repository.CrudRepository;


public interface UserDTORepository extends CrudRepository<UserDTO,Long> {
}
