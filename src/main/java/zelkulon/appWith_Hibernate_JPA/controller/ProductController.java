/**
 * Dastekin created on 04.04.2022 the ProductController-Class inside the package - zelkulon.appWith_Hibernate_JPA.controller
 */
package zelkulon.appWith_Hibernate_JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zelkulon.appWith_Hibernate_JPA.model.Product;
import zelkulon.appWith_Hibernate_JPA.repository.ProductDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductDao productDao;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false)String name) {
        try{
            List<Product> products = new ArrayList<Product>();

            if (name == null)
                productDao.findAll().forEach(products::add);
            else
                productDao.findByName(name).forEach(products::add);

            if(products.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
