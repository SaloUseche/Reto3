package reto3.backend.repositories2;
import reto3.backend.models.Laptop;
import reto3.backend.repositories.crud.ILaptopCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author dario
 */
@Repository
public class LaptopRepository {
    @Autowired
    private ILaptopCrudRepository crudLaptopRepository;
    /**
     * 
     * @return 
     */
    public List<Laptop> getAll() {
        return crudLaptopRepository.findAll();        
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Laptop> getById(Integer id) {
        return crudLaptopRepository.findById(id);
    }
    /**
     * 
     * @param laptop
     * @return 
     */
    public Laptop save(Laptop laptop) {
        return crudLaptopRepository.save(laptop);
    }
    /**
     * 
     * @param laptop 
     */
    public void update(Laptop laptop) {
        crudLaptopRepository.save(laptop);
    }
    /**
     * 
     * @param id 
     */
    public void delete(Integer id) {
        crudLaptopRepository.deleteById(id);
    }
}
