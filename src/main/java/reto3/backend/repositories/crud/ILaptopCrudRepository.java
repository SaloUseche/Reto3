package reto3.backend.repositories.crud;
import reto3.backend.models.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * 
 * @author dario
 */
public interface ILaptopCrudRepository extends MongoRepository<Laptop, Integer> {
}
