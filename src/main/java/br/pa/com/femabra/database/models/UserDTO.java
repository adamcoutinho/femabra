package br.pa.com.femabra.database.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String tokenSecurity;
    @Temporal(TemporalType.DATE)
    private Date dateUpdate;

    private LocalTime hourExpiration;
    private TypeUser typeUser;
    private String email;
    private String name;
    private String passwd;

    public UserDTO() {
    }

    public UserDTO(String tokenSecurity, Date dateUpdate, LocalTime hourExpiration, TypeUser typeUser, String email, String name, String passwd) {
        this.tokenSecurity = tokenSecurity;
        this.dateUpdate = dateUpdate;
        this.hourExpiration = hourExpiration;
        this.typeUser = typeUser;
        this.email = email;
        this.name = name;
        this.passwd = passwd;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTokenSecurity() {
        return tokenSecurity;
    }

    public void setTokenSecurity(String tokenSecurity) {
        this.tokenSecurity = tokenSecurity;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public LocalTime getHourExpiration() {
        return hourExpiration;
    }

    public void setHourExpiration(LocalTime hourExpiration) {
        this.hourExpiration = hourExpiration;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "ID=" + ID +
                ", tokenSecurity='" + tokenSecurity + '\'' +
                ", dateUpdate=" + dateUpdate +
                ", hourExpiration=" + hourExpiration +
                ", typeUser=" + typeUser +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
