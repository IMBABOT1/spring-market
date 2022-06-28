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


    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findAllByPriceAsc(){
        return productRepository.findAllByPriceAsc();
    }

    public List<Product> findAllByPriceDesc(){
        return productRepository.findAllByPriceDesc();
    }
}

