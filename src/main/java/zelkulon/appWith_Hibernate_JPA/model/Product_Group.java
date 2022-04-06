/**
 * Dastekin created on 04.04.2022 the Product_Group-Class inside the package - zelkulon.appWith_Hibernate_JPA.model
 */
package zelkulon.appWith_Hibernate_JPA.model;

import javax.persistence.*;
import java.math.BigInteger;

//TODO Constructor, getter , setter

@Entity
public class Product_Group {
    @Id
    private int product_group_nr;

    @Column(name = "name")
    private String name;

    @Column(name="id")
    private BigInteger id;

    @Column(name = "img")
    private String img;


    @Column(name = "department")
    private String department;
}
