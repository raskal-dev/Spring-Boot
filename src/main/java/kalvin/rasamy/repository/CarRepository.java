package kalvin.rasamy.repository;

import kalvin.rasamy.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarByMarkIgnoreCase(String mark);

    Collection<Car> findAllByMarkIsContainingIgnoreCase(String mark);

}
