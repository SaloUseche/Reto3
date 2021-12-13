package reto3.backend.services;
import reto3.backend.models.Order;
import reto3.backend.repositories2.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author 
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    /**
     * 
     * @return 
     */
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
    /**
     * 
     * @param zona
     * @return 
     */
    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }
    /**
     * 
     * @param order
     * @return 
     */
    public Order create(Order order) {
        Optional<Order> orderIdMaxima = orderRepository.lastUserId();
        if (order.getId() == null) {
            if (orderIdMaxima.isEmpty())
                order.setId(1);
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        Optional<Order> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.create(order);            
        }else{
            return order;
        }        
    }
    /**
     * 
     * @param order
     * @return 
     */
    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
