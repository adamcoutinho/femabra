package br.pa.com.femabra.database.models;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "prodcut")
public class ProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NAME;

    private BigDecimal VLR;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public BigDecimal getVLR() {
        return VLR;
    }

    public void setVLR(BigDecimal VLR) {
        this.VLR = VLR;
    }
}
