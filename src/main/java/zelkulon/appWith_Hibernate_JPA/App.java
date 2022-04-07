package zelkulon.appWith_Hibernate_JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zelkulon.appWith_Hibernate_JPA.model.Product;
import zelkulon.appWith_Hibernate_JPA.repository.ProductDao;

import java.math.BigInteger;

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @Component
    class ProductsCommandLineRunner implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {

            for (Product b : this.productDao.findAll())
                System.out.println(b.toString());
        }
        @Autowired
        ProductDao productDao;
    }

    @Bean
    public CommandLineRunner test(ProductDao productDao) {
        return args   -> {

            System.out.println("Create Product");
            var p = new Product();
            Log4J2LoggingSystem.SYSTEM_PROPERTY.isEmpty();
            int binInt_int= 123123;
            BigInteger testBiugInt = (BigInteger.TEN);

            p.setName( "testItem");

            p.setName_manufacturer("testManufacturere");

            p.setEan(testBiugInt);

            productDao.save(p);

            System.out.println("Product, saved");
            Log4J2LoggingSystem.SYSTEM_PROPERTY.isEmpty();

        };
    }

}
