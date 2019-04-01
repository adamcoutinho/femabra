package br.pa.com.femabra.database.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "card")
public class CardDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToMany(mappedBy = "card"    )

    private List<BoardDTO> board;


}
