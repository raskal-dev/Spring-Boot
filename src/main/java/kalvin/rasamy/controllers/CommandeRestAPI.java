package kalvin.rasamy.controllers;


import kalvin.rasamy.services.CommandeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/commandes")
public class CommandeRestAPI {
    private final CommandeService commandeService;


    public CommandeRestAPI(CommandeService commandeService) {
        this.commandeService = commandeService;
    }
}
