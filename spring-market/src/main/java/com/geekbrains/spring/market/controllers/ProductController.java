package com.geekbrains.spring.market.controllers;

import com.geekbrains.spring.market.entities.Product;
import com.geekbrains.spring.market.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductServices productServices;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("products", productServices.findAll());
        return "products";
    }

    @GetMapping("/asc")
    public String findAllByPriceAsc(Model model) {
        model.addAttribute("products", productServices.findAllByPriceAsc());
        return "productsAsc";
    }

    @GetMapping("/desc")
    public String findAllByPriceDesc(Model model){
        model.addAttribute("products", productServices.findAllByPriceDesc());
        return "productsDesc";
    }
}
