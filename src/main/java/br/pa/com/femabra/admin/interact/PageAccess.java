package br.pa.com.femabra.admin.interact;

import br.pa.com.femabra.database.models.UserDTO;

public enum PageAccess {
    ;


    private UserDTO userDTO;

    PageAccess(UserDTO userDTO) {
        this.userDTO = userDTO;
    }


}
