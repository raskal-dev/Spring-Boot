package kalvin.rasamy.services;

import kalvin.rasamy.entities.Car;
import kalvin.rasamy.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car getCarById(long idCar) {
        LOGGER.info("NAHAZO VOITURE ANAKIRAY ... ");
        return carRepository.findById(idCar).orElseThrow(() -> { throw new RuntimeException("LA VOITURE N'EST PAS TROUVÉE "); });
    }

    @Override
    public Car saveCar(Car car) {
        LOGGER.info("TAFIDITRA IZY ... ");
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(long idCar, Car car) {
        car.setId(idCar);
        LOGGER.info("MODIFICATION RÉUSSIE ... ");
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car) {
        LOGGER.info("MODIFICATION RÉUSSIE ... ");
        return carRepository.save(car);
    }

    @Override
    public Car deleteCar(long idCar) {
        LOGGER.warn("SUPPRESSION RÉUSSIE ... ");
        Car car = getCarById(idCar);
        carRepository.delete(car);
        return car;
    }

    @Override
    public Collection<Car> getAllCars() {
        LOGGER.info("LISTE RÉCUPÉRÉE ... ");
        return carRepository.findAll();
    }

    @Override
    public Collection<Car> getCarsByVendu() {
        LOGGER.info("LISTE DES VOITURE NON VENDU RÉCUPÉRÉE ....");
        return carRepository.findCarsByVendu(false);
    }

    @Override
    public Collection<Car> findByMark(String mark) {
        LOGGER.info("VOITURE RÉCUPÉRÉE AVEC UNE MARQUE PRÉCISE ... ");
        return carRepository.findAllByMarkIsContainingIgnoreCase(mark);
    }

    @Override
    public String sendMail() {
        return null;
    }
}
