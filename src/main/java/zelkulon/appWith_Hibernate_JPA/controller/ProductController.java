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
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {

    @RequestMapping("/hello1")
    public String home() {
        return "hello World!";
    }
    @Autowired
    ProductDao productDao;

  /*  @RequestMapping("/adssress")
    public String komplexer(
            @RequestParam(value = "user",defaultValue = "World" )String name)
    {



    }*/

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String name) {
        try {
            List<Product> products = new ArrayList<>();

            if (name == null)
                products.addAll(productDao.findAll());
            else
                products.addAll((Collection<? extends Product>) productDao.findByName(name));

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{product_nr}")
    public ResponseEntity<Product> getProductById(@PathVariable("product_nr") Integer product_nr) {
        Optional<Product> productData = productDao.findById(product_nr);

        if (productData.isPresent()) {
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            Product _product = productDao
                    .save(new Product(product.getName(), product.getName_manufacturer(), product.getEan()));
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/{product_nr}")
    public ResponseEntity<Product> updateTutorial(@PathVariable("product_nr") Integer product_nr, @RequestBody Product product) {
        Optional<Product> productData = productDao.findById(product_nr);

        if (productData.isPresent()) {
            Product _product = productData.get();
            _product.setName(product.getName());
            _product.setName_manufacturer(product.getName_manufacturer());
            _product.setEan(product.getEan());
            return new ResponseEntity<>(productDao.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{product_nr}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("product_nr") Integer product_nr) {
        try {
            productDao.deleteById(product_nr);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteAllProducts() {
        try {
            productDao.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*@GetMapping("/products/mhd")
    public ResponseEntity<List<Product>> findByMhd() {
        try {
            List<Product> products = productDao.findByMhd(LocalDate.now());

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}
