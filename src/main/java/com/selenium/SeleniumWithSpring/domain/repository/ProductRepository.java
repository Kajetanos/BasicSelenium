package com.selenium.SeleniumWithSpring.domain.repository;

import com.selenium.SeleniumWithSpring.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em ;

    public List<Product> getAllProducts() {
        Query query = em.createQuery("SELECT e FROM Product e");
        List<Product> products = query.getResultList();
        return products;
    }
    @Transactional
    public Product createProduct(String description , String price, String condition ) {

        Product product = new Product( description ,  price, condition ) ;
//        Product productNew = new Product( "sdfsd" ,  "dsf", "fds" ) ;
        em.persist(product);

        return product;
    }
}
