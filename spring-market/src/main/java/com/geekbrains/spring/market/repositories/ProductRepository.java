package com.geekbrains.spring.market.repositories;

import com.geekbrains.spring.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceOrderByPriceDesc(int price);
    List<Product> findAllByPriceOrderByPriceAsc(int price);

    List<Product> findAllBy();
}
