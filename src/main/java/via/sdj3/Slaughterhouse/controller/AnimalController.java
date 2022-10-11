package via.sdj3.Slaughterhouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.Slaughterhouse.model.Animal;
import via.sdj3.Slaughterhouse.service.AnimalServiceImplementation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AnimalController {
    private Logger logger = LoggerFactory.getLogger(AnimalController.class);
    private AnimalServiceImplementation animalService;

    public AnimalController(AnimalServiceImplementation animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/animals")
    public ResponseEntity<Object> createAnimal(@RequestBody Animal animal) {
        try {
            Animal createdAnimal = animalService.create(animal);
            return new ResponseEntity<Object>(createdAnimal, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/animals")
    public ResponseEntity<Object> getAll() {
        try {
            List<Animal> animals = animalService.getAll();
            return new ResponseEntity<Object>(animals, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/animals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimalById(@PathVariable("id") Integer id) {
        try {
            Optional<Animal> animal = animalService.getAnimalById(id);
            if (animal.isPresent()) {
                return new ResponseEntity<Object>(animal.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/animals/origin/{origin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimalsByOrigin(@PathVariable("origin") String origin) {
        try {
            List<Animal> animals = animalService.getAllAnimalsByOrigin(origin);
            if (animals.size() > 0) {
                return new ResponseEntity<Object>(animals, HttpStatus.OK);

            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/animals/date", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimalsByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        try {
            List<Animal> animals = animalService.getAllAnimalsByDate(date);
            if (animals.size() > 0) {
                return new ResponseEntity<Object>(animals, HttpStatus.OK);

            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/animals/{id}")
    public ResponseEntity<Object> updateAnimal(@PathVariable("id") Integer id, @RequestBody Animal animal) {
        try {
            animal.setRegNum(id);
            Animal createAnimal = animalService.update(animal);
            return new ResponseEntity<Object>(createAnimal, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/animals/{id}")
    public ResponseEntity<HttpStatus> deleteAnimal(@PathVariable("id") Integer id) {
        try {
            animalService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}

