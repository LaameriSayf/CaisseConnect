package CaisseConnect.entities.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long idClient;
    private String nom;
    private String prenom;
    private Integer tel;
    private String rib;

    public ClientDto(Long idClient,String nom, String prenom, String rib,Integer tel ) {
        this.idClient=idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.rib = rib;
        this.tel = tel;
    }
}
