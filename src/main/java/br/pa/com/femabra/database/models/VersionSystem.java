package br.pa.com.femabra.database.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="version_crm")
public class VersionSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;

    private LocalDate dateRegister;

    private LocalDateTime dateHourRegister;

    private String obs;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public LocalDateTime getDateHourRegister() {
        return dateHourRegister;
    }

    public void setDateHourRegister(LocalDateTime dateHourRegister) {
        this.dateHourRegister = dateHourRegister;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
