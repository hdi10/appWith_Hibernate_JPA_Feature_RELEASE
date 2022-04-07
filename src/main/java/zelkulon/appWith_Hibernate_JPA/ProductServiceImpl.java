/**
 * Dastekin created on 06.04.2022 the ProductServiceImpl-Class inside the package - zelkulon.appWith_Hibernate_JPA
 */
package zelkulon.appWith_Hibernate_JPA;

import org.springframework.beans.factory.annotation.Autowired;
import zelkulon.appWith_Hibernate_JPA.model.Product;
import zelkulon.appWith_Hibernate_JPA.repository.ProductDao;

public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao dao;
    @Override
    public Product findByName_from_Service(String name) {
        return (Product) dao.findByName(name);
    }
}
