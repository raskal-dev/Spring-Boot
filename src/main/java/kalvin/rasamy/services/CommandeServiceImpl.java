package kalvin.rasamy.services;

import kalvin.rasamy.entities.Commande;
import kalvin.rasamy.repository.CommandeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {

    private final Logger LOGGER = LoggerFactory.getLogger(CommandeServiceImpl.class);

    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Commande getCommandeById(long idCom) {
        LOGGER.info("Liste d'un commande ...");
        return commandeRepository.findById(idCom).orElseThrow(() -> { throw new RuntimeException("La commande n'est pas trouver"); });
    }

    @Override
    public Commande saveCommande(Commande commande) {
        LOGGER.info("Tafiditra izy ...");
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(long idCom, Commande commande) {
        commande.setId(idCom);
        LOGGER.info("MODIFFICATION AVEC SUCCESS...");
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        LOGGER.info("MODIFFICATION AVEC SUCCES...");
        return commandeRepository.save(commande);
    }

    @Override
    public Commande deleteCommande(long idCom) {
        LOGGER.warn("SUPPRESSION AVEC SUCCES...");
        Commande commande = getCommandeById(idCom);
        commandeRepository.delete(commande);
        return commande;
    }

    @Override
    public Collection<Commande> getAll() {
        LOGGER.info("LISTE RÉCUPÉRÉ...");
        return commandeRepository.findAll();
    }

    @Override
    public Collection<Commande> findByNomCli(String nomCli) {
        LOGGER.info("COMMANDE D'UN CLIENT RÉCUPÉRÉ....");
        return commandeRepository.findAllByNomCliIsContainingIgnoreCase(nomCli);
    }


}
