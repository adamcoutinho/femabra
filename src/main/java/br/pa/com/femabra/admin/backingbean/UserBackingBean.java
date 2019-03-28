package br.pa.com.femabra.admin.backingbean;

import br.pa.com.femabra.database.models.UserDTO;

public class UserBackingBean {


    private String email;

    private UserDTO user;

    private String tokenReceived;


    private boolean activeFieldsUser;


    public boolean isActiveFieldsUser() {
        return activeFieldsUser;
    }

    public void setActiveFieldsUser(boolean activeFieldsUser) {
        this.activeFieldsUser = activeFieldsUser;
    }

    public String getTokenReceived() {
        return tokenReceived;
    }

    public void setTokenReceived(String tokenReceived) {
        this.tokenReceived = tokenReceived;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
