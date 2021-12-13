package reto3.backend.repositories.crud;
import reto3.backend.models.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * 
 * @author dario
 */
public interface IUserCrudRepository extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
}
