package sillas.JaxRsWithPanache.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import sillas.JaxRsWithPanache.entities.Product;

@ApplicationScoped
public class ProductService {

    // Como seria utilizando repository
    // @Inject
    // ProductRepository repository;

    // public List<Product> findAll() {
    //     return repository.listAll();
    // }

    // public List<Product> findByName(String name) {
    //     return repository.findByName(name);
    // }

    // public List<Product> findByNameOrderByPrice(String name) {
    //     return repository.findByNameOrderByPrice(name);
    // }

    // public Product findByIdentifier(Long id) {
    //     return repository.findByIdentifier(id);
    // }

    // public List<Product> findOfPriceHigherThan(Double price) {
    //     return repository.findOfPriceHigherThan(price);
    // }

    // public Product save(Product Product) {
    //     repository.persist(Product);
    //     return Product;
    // }
    
    // public Product update(Long id, Product Product) {
    //     Product ProductToUpdate = repository.findById(id);
    //     ProductToUpdate.setName(Product.getName());
    //     ProductToUpdate.setPrice(Product.getPrice());
    //     repository.persist(ProductToUpdate);
    //     return Product;
    // }

    // public void deleteById(Long id) {
    //     repository.deleteById(id);
    // }

    // estendendo panache na propria classe
    public List<Product> findAll() {
        return Product.listAll();
    }

    public List<Product> findByName(String name) {
        return Product.findByName(name);
    }

    public List<Product> findByNameOrderByPrice(String name) {
        return Product.findByNameOrderByPrice(name);
    }

    public Product findByIdentifier(Long id) {
        return Product.findByIdentifier(id);
    }

    public List<Product> findOfPriceHigherThan(Double price) {
        return Product.findOfPriceHigherThan(price);
    }

    public Product save(Product product) {
        product.persist();
        return product;
    }
    
    public Product update(Long id, Product product) {
        Product ProductToUpdate = Product.findById(id);
        ProductToUpdate.name = product.name;
        ProductToUpdate.price = product.price;
        ProductToUpdate.persist();
        return product;
    }

    public void deleteById(Long id) {
        Product.deleteById(id);
    }
}
