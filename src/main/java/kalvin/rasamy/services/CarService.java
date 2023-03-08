package kalvin.rasamy.services;

import kalvin.rasamy.entities.Car;

import java.util.Collection;

public interface CarService {

    Car getCarById(long idCar);

    Car saveCar(Car car);

    Car updateCar(long idCar, Car car);

    Car updateCar(Car car);

    Car deleteCar(long idCar);

    Collection<Car> getAllCars();

    Collection<Car> getCarsByVendu();

    Collection<Car> findByMark(String mark);

    String sendMail();

}
