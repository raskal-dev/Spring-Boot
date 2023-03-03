package kalvin.rasamy.controllers;


import kalvin.rasamy.entities.Commande;
import kalvin.rasamy.entities.MyResponse;
import kalvin.rasamy.services.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
}
