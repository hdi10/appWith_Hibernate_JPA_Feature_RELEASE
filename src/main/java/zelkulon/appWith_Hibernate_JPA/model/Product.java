/**
 * Dastekin created on 04.04.2022 the Product-Class inside the package - zelkulon.appWith_Hibernate_JPA.model
 */
package zelkulon.appWith_Hibernate_JPA.model;

import javax.persistence.*;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

//TODO Constructor, getter , setter

@Entity
@Table(name = "Product")
public class Product {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_auto", nullable = false)
    private Long id_auto;

    private int id;

    @Column(name = "product_nr")
    private int product_nr;

    @Column(name = "name")
    private String name;

    @Column(name = "name_manufacturer")
    private String name_manufacturer;

    @Column(name = "ean")
    private BigInteger ean;

    @ElementCollection
    @CollectionTable(name = "inhalt")
    private List<String> inhalt;

    @Column(name = "mhd")
    private String mhd;

    public Long getId_auto() {
        return id_auto;
    }

    public void setId_auto(Long id_auto) {
        this.id_auto = id_auto;
    }

    public Product() {

    }

    public Product(int product_nr, String name, String name_manufacturer, BigInteger ean, List<String> inhalt, String mhd) {
        this.product_nr = product_nr;
        this.name = name;
        this.name_manufacturer = name_manufacturer;
        this.ean = ean;
        this.inhalt = inhalt;
        this.mhd = mhd;
    }


    public int getProduct_nr() {
        return product_nr;
    }

    public void setProduct_nr(int product_nr) {
        this.product_nr = product_nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_manufacturer() {
        return name_manufacturer;
    }

    public void setName_manufacturer(String name_manufacturer) {
        this.name_manufacturer = name_manufacturer;
    }

    public BigInteger getEan() {
        return ean;
    }

    public void setEan(BigInteger ean) {
        this.ean = ean;
    }

    public List<String> getInhalt() {
        return inhalt;
    }

    public void setInhalt(List<String> inhalt) {
        this.inhalt = inhalt;
    }

    public String getMhd() {
        return mhd;
    }

    public void setMhd(String mhd) {
        this.mhd = mhd;
    }

    @Override
    public String toString() {
        return "Product [" +
                "product_nr=" + product_nr +
                ", name='" + name + '\'' +
                ", name_manufacturer='" + name_manufacturer + '\'' +
                ", ean=" + ean +
                ", inhalt=" + inhalt +
                ", mhd=" + mhd +
                ']';
    }
}
