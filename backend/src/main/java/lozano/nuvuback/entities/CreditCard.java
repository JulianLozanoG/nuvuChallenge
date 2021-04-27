package lozano.nuvuback.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CARD_ID", updatable = false, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    @JsonBackReference
    private Client clientId;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CARD_BRAND")
    private String cardBrand;

    @Column(name = "KEYNUMBER_CARD")
    private String keyNumber;

    @Column(name = "EXPIRATION_DATE")
    private Date expiration;
}
