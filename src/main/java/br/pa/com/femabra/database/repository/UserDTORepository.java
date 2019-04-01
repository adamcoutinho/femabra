package br.pa.com.femabra.database.repository;

import br.pa.com.femabra.database.models.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserDTORepository extends CrudRepository<UserDTO,Long> {

    @Query(
            value = "SELECT u FROM UserDTO u where u.email like :email"
            )
     UserDTO findByDescribeEmail(@Param("email")String email);



}
