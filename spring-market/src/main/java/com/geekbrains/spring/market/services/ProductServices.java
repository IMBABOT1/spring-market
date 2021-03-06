package com.geekbrains.spring.market.services;

import com.geekbrains.spring.market.entities.Product;
import com.geekbrains.spring.market.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServices {
    private ProductRepository productRepository;


    public Page<Product> findAll(int page, int size){
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public List<Product> findOneByPriceASC(){
        return productRepository.findAllByPriceASC(PageRequest.of(0, 1));
    }

    public List<Product> findOneByPriceDesc(){
        return productRepository.findAllByPriceDESC(PageRequest.of(0, 1));
    }

    public List<Product> findMinMaxPriceProduct(){
        List<Product> list = new ArrayList<>();
        list.add(productRepository.findAllByPriceDESC(PageRequest.of(0, 1)).get(0));
        list.add(productRepository.findAllByPriceASC(PageRequest.of(0, 1)).get(0));
        return list;
    }

    public List<Product> findAllByPriceMin(int minPrice){
        return productRepository.findAllByPriceIsGreaterThanEqual(minPrice);
    }

    public List<Product> findAllByPriceMax(int maxPrice){
        return productRepository.findAllByPriceIsLessThanEqual(maxPrice);
    }

    public List<Product> findByMinAndMax(int min, int max){
        return productRepository.findAllByPriceIsGreaterThanEqualAndPriceIsLessThanEqual(min, max);
    }
}

