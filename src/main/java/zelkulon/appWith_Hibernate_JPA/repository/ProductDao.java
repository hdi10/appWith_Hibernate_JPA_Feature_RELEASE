package zelkulon.appWith_Hibernate_JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zelkulon.appWith_Hibernate_JPA.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);
    List<Product> findByMhd(LocalDate mhd);
}
