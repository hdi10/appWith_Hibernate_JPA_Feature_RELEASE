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

    public Product_Group() {
    }

    public Product_Group(int product_group_nr, String name, BigInteger id, String img, String department) {
        this.product_group_nr = product_group_nr;
        this.name = name;
        this.id = id;
        this.img = img;
        this.department = department;
    }

    public int getProduct_group_nr() {
        return product_group_nr;
    }

    public void setProduct_group_nr(int product_group_nr) {
        this.product_group_nr = product_group_nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Product_Group [" +
                "product_group_nr=" + product_group_nr +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", department='" + department + '\'' +
                ']';
    }
}
