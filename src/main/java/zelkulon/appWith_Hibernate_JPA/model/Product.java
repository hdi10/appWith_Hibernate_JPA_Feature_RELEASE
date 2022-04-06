/**
 * Dastekin created on 04.04.2022 the Product-Class inside the package - zelkulon.appWith_Hibernate_JPA.model
 */
package zelkulon.appWith_Hibernate_JPA.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

//TODO Constructor, getter , setter

@Entity
@Table(name = "Product")
public class Product {
    @Id
    private int product_nr;

    @Column(name = "name")
    private String name;

    @Column(name="name_manufacturer")
    private String name_manufacturer;

    @Column(name = "ean")
    private BigInteger ean;

    @ElementCollection
    @CollectionTable(name = "inhalt")
    private List<String> inhalt;

    @Column(name = "mhd")
    private LocalDate mhd;


}
