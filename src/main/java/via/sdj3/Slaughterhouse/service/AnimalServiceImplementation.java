package via.sdj3.Slaughterhouse.service;

import org.springframework.stereotype.Service;
import via.sdj3.Slaughterhouse.model.Animal;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImplementation implements AnimalService{
    @Override
    public Animal create(Animal animal) {
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return null;
    }

    @Override
    public List<Animal> getAllAnimalsByDate(Date date) {
        return null;
    }

    @Override
    public Optional<Animal> getAnimalById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Animal update(Animal animal) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
