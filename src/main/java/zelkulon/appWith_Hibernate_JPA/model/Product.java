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
@Table(name = "product")
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

    public Product(int product_nr, String name, String name_manufacturer, BigInteger ean, List<String> inhalt, LocalDate mhd) {
        this.product_nr = product_nr;
        this.name = name;
        this.name_manufacturer = name_manufacturer;
        this.ean = ean;
        this.inhalt = inhalt;
        this.mhd = mhd;
    }

    public Product() {
    }

    public Product(String name, String name_manufacturer, BigInteger ean) {
        this.name = name;
        this.name_manufacturer =name_manufacturer;
        this.ean = ean;
    }

    public BigInteger getEan() {
        return ean;
    }

    public void setEan(BigInteger ean) {
        this.ean = ean;
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

    public List<String> getInhalt() {
        return inhalt;
    }

    public void setInhalt(List<String> inhalt) {
        this.inhalt = inhalt;
    }

    public LocalDate getMhd() {
        return mhd;
    }

    public void setMhd(LocalDate mhd) {
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
