package zelkulon.appWith_Hibernate_JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zelkulon.appWith_Hibernate_JPA.model.Product;
import zelkulon.appWith_Hibernate_JPA.model.Product_Group;
import java.util.List;

public interface ProductGroupDAO extends JpaRepository<Product_Group, Integer> {

    List<Product_Group> findByName(String name);
    List<Product_Group> findProduct_GroupByDepartment(String department);
}
