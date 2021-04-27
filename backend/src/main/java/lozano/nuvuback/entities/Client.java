package lozano.nuvuback.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID", updatable = false, nullable = false)
    @JsonProperty("client_id")
    private Integer id;

    @OneToMany(mappedBy = "clientId", cascade = CascadeType.ALL)
    @JsonProperty("credit_cards")
    @JsonManagedReference
    private List<CreditCard> creditCards;

    @Column(name = "FIRST_NAME")
    @JsonProperty("first_name")
    private String firstName;

    @Column(name = "LASTNAME")
    @JsonProperty("lastname")
    private String lastName;

    @Column(name = "IDENTIFICATION")
    @JsonProperty("identification")
    private String identification;

    @Column(name = "EMAIL")
    @JsonProperty("email")
    private String email;

    public Client(Client client) {
        this.id = client.getId();
        this.creditCards = client.getCreditCards();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.identification = client.getIdentification();
        this.email = client.getEmail();
    }

    public Client() {
    }
}
