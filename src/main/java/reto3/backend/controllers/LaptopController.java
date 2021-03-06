package reto3.backend.controllers;
import reto3.backend.models.Laptop;
import reto3.backend.services.LaptopService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 * darkus
 * @author dario
 */
@RestController
@RequestMapping("/api/laptop")
@CrossOrigin("*")
public class LaptopController {
    @Autowired
    private LaptopService servicio;
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<Laptop> listar(){
        return servicio.listar();
    } 
    /**
     * 
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Laptop> getLaptop(@PathVariable("id") Integer id) {
        return servicio.getById(id);
    }
    /**
     * 
     * @param laptop
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop laptop) {
        return servicio.create(laptop);
    } 
    /**
     * 
     * @param laptop
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop laptop) {
        return servicio.update(laptop);
    }    
    /**
     * 
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return servicio.delete(id);
    }  
}
