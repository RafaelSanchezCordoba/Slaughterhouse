package via.sdj3.Slaughterhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sdj3.Slaughterhouse.model.Animal;

import java.util.Date;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findAll(Date date);

    List<Animal> findAll(String origin);
}
