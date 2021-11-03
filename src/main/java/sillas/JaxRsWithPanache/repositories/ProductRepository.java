package sillas.JaxRsWithPanache.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import sillas.JaxRsWithPanache.entities.Product;

// classe dispensavel quando se utiliza 'active record'
@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    
    public List<Product> findByName(String name) {
        return list("name", name);
    }
    
    public List<Product> findByNameOrderByPrice(String name) {
        return list("name", Sort.ascending("price"), name);
    }

    public Product findByIdentifier(Long id) {
        return find("from Product where id = :id", Parameters.with("id", id)).firstResult();
    }
    
    public List<Product> findOfPriceHigherThan(Double price) {
        return list("select p from Product p where p.age > ?1", price);
    }
}
