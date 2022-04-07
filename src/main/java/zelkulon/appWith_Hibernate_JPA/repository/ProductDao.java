package zelkulon.appWith_Hibernate_JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zelkulon.appWith_Hibernate_JPA.model.Product;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    BigInteger myBigInt = BigInteger.TEN.multiply(BigInteger.valueOf(1323));
            //BigInteger.valueOf(activatScannerTOStartOutputStream().getThreadDone();)

    List<Product> getAllByNameOrderByName_manufacturerDesc(String name);


    //List<Product> findByName(String name);
    //List<Product> findByMhd(LocalDate mhd);

    @Query("select p from Product p where p.name = ?1")
    Product findByName(String name);

    @Query
    Product findByMhd(LocalDate mhd);

    @Query
    Product[] findByInhalt(List<String> inhalt);

    List<Product> findByEan(BigInteger myBigInt);
}
