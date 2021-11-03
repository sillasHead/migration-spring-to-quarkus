package sillas.JaxRsWithPanache.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;

@Entity
public class Product extends PanacheEntityBase {
    
    // como seria sem o PanacheEntity
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    // private String name;
    // private Double price;
    
    // public Product() {
    // }

    // public Product(Long id, String name, Double price) {
    //     this.id = id;
    //     this.name = name;
    //     this.price = price;
    // }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public Double getPrice() {
    //     return price;
    // }

    // public void setPrice(Double price) {
    //     this.price = price;
    // }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Double price;
    
    public static List<Product> findByName(String name) {
        return list("name", name);
    }
    
    public static List<Product> findByNameOrderByPrice(String name) {
        return list("name", Sort.ascending("price"), name);
    }

    public static Product findByIdentifier(Long id) {
        return find("from Product where id = :id", Parameters.with("id", id)).firstResult();
    }
    
    public static List<Product> findOfPriceHigherThan(Double price) {
        return list("select p from Product p where p.age > ?1", price);
    }
}
