package kalvin.rasamy.services;

import kalvin.rasamy.entities.Commande;

import java.util.Collection;

public interface CommandeService {

    Commande getCommandeById(long idCom);

    Commande saveCommande(Commande commande);

    Commande updateCommande(long idCom, Commande commande);

    Commande updateCommande(Commande commande);

    Commande deleteCommande(long idCom);

    Collection<Commande> getAll();

    Collection<Commande> findByNomCli(String nomCli);
}
