package via.sdj3.Slaughterhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import via.sdj3.Slaughterhouse.model.Animal;

import java.util.Date;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
