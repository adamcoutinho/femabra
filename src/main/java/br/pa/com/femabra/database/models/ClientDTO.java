package br.pa.com.femabra.database.models;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class ClientDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;



}
