package lozano.nuvuback.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_ID", updatable = false, nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "clientId")
    private List<CreditCard> creditCards;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "IDENTIFICATION")
    private String identification;

    @Column(name = "EMAIL")
    private String email;
}
