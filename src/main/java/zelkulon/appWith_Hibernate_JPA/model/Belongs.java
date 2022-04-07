/**
 * Dastekin created on 04.04.2022 the Belongs-Class inside the package - zelkulon.appWith_Hibernate_JPA.model
 */
package zelkulon.appWith_Hibernate_JPA.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//TODO composite key

@Entity
public class Belongs {
    @Id
    private int product_nr;

    @Id
    private int product_group_nr;


}
