package via.sdj3.Slaughterhouse.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import via.sdj3.Slaughterhouse.model.Animal;
import via.sdj3.Slaughterhouse.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
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
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> getAllAnimalsByDate(LocalDate date) {
        List<Animal> animalList = new ArrayList<>();

        for (Animal animal : animalRepository.findAll()) {
            if (animal.getDate().getDayOfMonth() == date.getDayOfMonth() &&
                    animal.getDate().getMonth() == date.getMonth()
                    && animal.getDate().getYear() == date.getYear()) {

                animalList.add(animal);
            }
        }

        return animalList;
    }

    @Override
    public List<Animal> getAllAnimalsByOrigin(String origin) {
        List<Animal> animals = animalRepository.findAll();
        List<Animal> list = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getOrigin().equals(origin)) {
                list.add(animals.get(i));
            }
        }
        return list;
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
