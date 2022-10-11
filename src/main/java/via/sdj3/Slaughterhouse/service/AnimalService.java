package via.sdj3.Slaughterhouse.service;

import via.sdj3.Slaughterhouse.model.Animal;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AnimalService {
    Animal create(Animal animal);
    List<Animal> getAll();
    List<Animal> getAllAnimalsByDate(LocalDate date);
    List<Animal> getAllAnimalsByOrigin(String origin);
    Optional<Animal> getAnimalById(Integer id);
    Animal update(Animal animal);
    void deleteById(Integer id);

}
