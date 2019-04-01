package br.pa.com.femabra.database.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "board")
public class BoardDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;


    @ManyToOne
    @JoinColumn(name = "board_id")
    private CardDTO card;




}
