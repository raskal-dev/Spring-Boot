package kalvin.rasamy.controllers;


import kalvin.rasamy.entities.Commande;
import kalvin.rasamy.entities.MyResponse;
import kalvin.rasamy.services.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import java.io.ByteArrayOutputStream;
import java.util.Optional;



@RestController
@RequestMapping(path = "/api/commandes")
public class CommandeRestAPI {
    private final CommandeService commandeService;


    public CommandeRestAPI(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<MyResponse> getAll() {
        MyResponse response = MyResponse.builder().message("Liste des commandes récupérées ... ").object(commandeService.getAllCommande()).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<MyResponse> saveData(@RequestBody Commande commande) {
        return ResponseEntity.ok(MyResponse.builder().message("Enregistrement est avec succès ... ").object(commandeService.saveCommande(commande)).build());
    }

    @DeleteMapping(path = "/delete/{idCom}")
    public ResponseEntity<MyResponse> deleteCommande(@PathVariable(name = "idCom") long id) {
        return ResponseEntity.ok(MyResponse.builder().message("Suppression est succès ...").object(commandeService.deleteCommande(id)).build());
    }

    @GetMapping(path = "/byId/{idCom}")
    public ResponseEntity<MyResponse> getByIdCom(@PathVariable(name = "idCom") long id) {
        return ResponseEntity.ok(MyResponse.builder().message("Une Commande Trouver ...").object(commandeService.getCommandeById(id)).build());
    }

    @GetMapping(path = "/byNomCli/{nomCli}")
    public ResponseEntity<MyResponse> getByNomCli(@PathVariable(name = "nomCli") String cli) {
        if (commandeService.findByNomCli(cli).size() != 0) {
            return ResponseEntity.ok(MyResponse.builder().message("UNE LISTE A ÉTÉ TROUVÉE !!").object(commandeService.findByNomCli(cli)).build());
        }
        return ResponseEntity.ok(MyResponse.builder().message("AUCUN VOITURE TROUVÉE !!").build());
    }

    @PutMapping(path = "/update/{idCom}")
    public ResponseEntity<MyResponse> updateCommande(@RequestBody Commande commande, @PathVariable(name = "idCom") long id) {
        return ResponseEntity.ok(MyResponse.builder().message("Mise à jour avec succès ...").object(commandeService.updateCommande(id, commande)).build());
    }

//    @GetMapping(path = "/export/pdf/{idCom}")
//    public ResponseEntity<byte[]> exportToPdf(@PathVariable(name = "idCom") long id) throws Exception {
//        // obtenir la commande par son id
//        Commande commande = commandeService.getCommandeById(id);
//
//        // créer un document PDF
//        Document document = new Document(PageSize.A4);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        PdfWriter.getInstance(document, baos);
//        document.open();
//
//        // ajouter les informations de commande dans le document
//        document.add(new Paragraph("ID de commande : " + commande.getId()));
//        document.add(new Paragraph("Nom du client : " + commande.getNomCli()));
//        document.add(new Paragraph("Numéro de téléphone du client : " + commande.getNumCli()));
//        document.add(new Paragraph("Matricule de voiture : " + commande.getMatriculeVoiture()));
//        document.add(new Paragraph("Marque de voiture : " + commande.getMarqueVoiture()));
//        document.add(new Paragraph("Type de voiture : " + commande.getTypeVoiture()));
//        document.add(new Paragraph("Nombre de places de voiture : " + commande.getNbPlaceVoiture()));
//        document.add(new Paragraph("Prix de voiture : " + commande.getPriceVoiture()));
//
//        // fermer le document
//        document.close();
//
//        // retourner le document PDF en tant que tableau d'octets
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        headers.setContentDispositionFormData("attachment", "commande-" + id + ".pdf");
//        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
//    }

}
