package com.geekbrains.spring.market.services;

import com.geekbrains.spring.market.entities.Product;
import com.geekbrains.spring.market.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServices {
    private ProductRepository productRepository;

    public List<Product> findAllByPriceAsc(int price) {
        return productRepository.findAllByPriceOrderByPriceAsc(price);
    }

    public List<Product> findAllByPriceDesc(int price){
        return productRepository.findAllByPriceOrderByPriceDesc(price);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}

