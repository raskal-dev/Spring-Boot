package kalvin.rasamy.controllers;


import kalvin.rasamy.entities.Car;
import kalvin.rasamy.entities.MyResponse;
import kalvin.rasamy.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/voitures")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarRestAPI {

    private final CarService carService;

    public CarRestAPI(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<MyResponse> getAll() {
        MyResponse response = MyResponse.builder().message("liste récupérée ...").object(carService.getAllCars()).build();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/vendu")
    public ResponseEntity<MyResponse> getCarsByVendu() {
        MyResponse response = MyResponse.builder().message("liste non vendu récupérée ... ").object(carService.getCarsByVendu()).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<MyResponse> saveData(@RequestBody Car car) {
        return ResponseEntity.ok(MyResponse.builder().message("ENREGISTRÉE TSARA MIHINTSY ... ").object(carService.saveCar(car)).build());
    }

    @DeleteMapping(path = "/delete/{idCar}")
    public ResponseEntity<MyResponse> deleteCar(@PathVariable(name = "idCar") long id) {
        return ResponseEntity.ok(MyResponse.builder().message("SUPPRESSION AVEC SUCCÈS !!").object(carService.deleteCar(id)).build());
    }

    @GetMapping(path = "/byId/{idCar}")
    public ResponseEntity<MyResponse> byId(@PathVariable(name = "idCar") long id) {
        return ResponseEntity.ok(MyResponse.builder().message("UNE VOITURE A ÉTÉ TROUVÉE !!").object(carService.getCarById(id)).build());
    }


    @GetMapping(path = "/byMark/{mark}")
    public ResponseEntity<MyResponse> byMark(@PathVariable(name = "mark") String marks) {
        if (carService.findByMark(marks).size() != 0) {
            return ResponseEntity.ok(MyResponse.builder().message("UNE LISTE A ÉTÉ TROUVÉE !!").object(carService.findByMark(marks)).build());
        }
        return ResponseEntity.ok(MyResponse.builder().message("AUCUN VOITURE TROUVÉE !!").build());
    }

    @PutMapping(path = "/update/{idCar}")
    public ResponseEntity<MyResponse> update(@RequestBody Car car, @PathVariable(name = "idCar") long id) {
        return ResponseEntity.ok(MyResponse.builder().message("MODIFICATION AVEC SUCCÈS !!").object(carService.updateCar(id, car)).build());
//        car.setId(id);
//        return ResponseEntity.ok(MyResponse.builder().message("MODIFICATION AVEC SUCCÈS !!").object(carService.updateCar(car)).build());
    }

}
