package com.geekbrains.spring.market.repositories;

import com.geekbrains.spring.market.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p order by p.price asc")
    List<Product>findAllByPriceASC(Pageable pageable);

    @Query("select p from Product p order by p.price desc ")
    List<Product>findAllByPriceDESC(Pageable pageable);


}
