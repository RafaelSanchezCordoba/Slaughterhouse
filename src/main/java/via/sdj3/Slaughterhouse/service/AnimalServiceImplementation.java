package via.sdj3.Slaughterhouse.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import via.sdj3.Slaughterhouse.model.Animal;
import via.sdj3.Slaughterhouse.repository.AnimalRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnimalServiceImplementation implements AnimalService{
    private final AnimalRepository animalRepository;

    @Override
    public Animal create(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> getAll() {
        return (List<Animal>) animalRepository.findAll();
    }

    @Override
    public List<Animal> getAllAnimalsByDate(Date date) {
        return animalRepository.findAll(date);
    }

    @Override
    public List<Animal> getAllAnimalsByOrigin(String origin) {
        return animalRepository.findAll(origin);
    }

    @Override
    public Optional<Animal> getAnimalById(Integer id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal update(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void deleteById(Integer id) {
        animalRepository.deleteById(id);
    }
}
