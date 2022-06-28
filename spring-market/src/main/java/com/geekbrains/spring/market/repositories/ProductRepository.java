package com.geekbrains.spring.market.repositories;

import com.geekbrains.spring.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBy();


    @Query("select p from Product p order by p.price")
    List<Product> findAllByPriceAsc();

    @Query("select p from Product p order by p.price desc")
    List<Product> findAllByPriceDesc();
}
