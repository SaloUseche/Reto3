package reto3.backend.repositories2;
import reto3.backend.models.Order;
import reto3.backend.repositories.crud.IOrderCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author dario
 */
@Repository
public class OrderRepository {
    @Autowired
    private IOrderCrudRepository orderCrudRepository;
    /**
     * 
     * @return 
     */
    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }
    /**
     * 
     * @param zona
     * @return 
     */
    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }
    /**
     * 
     * @param order
     * @return 
     */
    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }
    /**
     * 
     * @param order 
     */
    public void update(Order order) {
        orderCrudRepository.save(order);
    }
    /**
     * 
     * @param order 
     */
    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    /**
     * 
     * @return 
     */
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
}
