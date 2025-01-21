package CaisseConnect.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient ;
    private String Nom ;
    private String Prenom ;
    private Integer Tel ;
    @Column(unique = true)
    private String RIB ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private Set<Commande> Commandes;


    @OneToOne(mappedBy="client")
    private User user;


}
