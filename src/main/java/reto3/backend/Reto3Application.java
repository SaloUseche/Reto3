package reto3.backend;
import reto3.backend.models.Laptop;
import reto3.backend.models.Order;
import reto3.backend.models.User;
import reto3.backend.repositories.crud.IOrderCrudRepository;
import reto3.backend.repositories.crud.IUserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reto3.backend.repositories.crud.ILaptopCrudRepository;
/**
 * darkus
 * @author dario
 */
@SpringBootApplication
public class Reto3Application implements CommandLineRunner {
    @Autowired
    private ILaptopCrudRepository crudRepository;
    @Autowired
    private IUserCrudRepository userCrudRepository;
    @Autowired
    private IOrderCrudRepository orderCrudRepository;
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        SpringApplication.run(Reto3Application.class, args);
    }
    /**
     * 
     * @param args
     * @throws Exception 
     */
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        crudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
        Optional<User> salesManOne = userCrudRepository.findById(3);
        Optional<User> salesManTwo = userCrudRepository.findById(6);
        Map<String, Laptop> productOrderOne = new HashMap<String, Laptop>();
        Map<String, Laptop> productOrderTwo = new HashMap<String, Laptop>();
        Map<String, Integer> quantitiesOrderOne = new HashMap<String, Integer>();
        Map<String, Integer> quantitiesOrderTwo = new HashMap<String, Integer>();
        System.out.println("Listado de ordenes");
        orderCrudRepository.findAll().forEach(System.out::println);       
    }
}