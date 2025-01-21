package CaisseConnect.services;

import CaisseConnect.entities.Cheque;
import CaisseConnect.repositories.ChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class NotificationService {

    @Autowired
    private ChequeRepository chequeRepository;

    @Autowired
    private MailService mailService;

    public void envoyerNotifications() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextDay = now.plusHours(24);

        List<Cheque> cheques = chequeRepository.findChequesWithEcheanceProche(now, nextDay);

        for (Cheque cheque : cheques) {
            String emailBody = "Bonjour Ms Amara ," +
                    "Ce Client :"+cheque.getCommande().getClient().getNom() + " "
                    + cheque.getCommande().getClient().getPrenom() + ",\n" +
                    "Son Chèque arrive à échéance le " + cheque.getDateFin() + ".\n" +
                    "Information :\n" +
                    "Montant : " + cheque.getMontant() + ".\n" +
                    "Date de création : " + cheque.getDateCreation() + ".\n\n" +
                    "Merci de prendre les mesures nécessaires.\n\nCordialement, Votre Service Client.";

            mailService.envoyerEmail("laamerisayf@gmail.com",
                    "Rappel : Ce chèque arrive à échéance",
                    emailBody);
        }
    }
}
