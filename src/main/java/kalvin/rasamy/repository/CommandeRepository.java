package kalvin.rasamy.repository;

import kalvin.rasamy.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    Commande findCarByNomCliIgnoreCase(String nomCli);

    Collection<Commande> findAllByNomCliIsContainingIgnoreCase(String nomCli);
}
