package zelkulon.appWith_Hibernate_JPA;

import org.springframework.stereotype.Service;
import zelkulon.appWith_Hibernate_JPA.model.Product;

@Service
public interface ProductService {
    public Product findByName_from_Service(String name);
}
