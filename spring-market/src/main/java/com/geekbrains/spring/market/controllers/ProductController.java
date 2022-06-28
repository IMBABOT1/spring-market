package com.geekbrains.spring.market.controllers;

import com.geekbrains.spring.market.entities.Product;
import com.geekbrains.spring.market.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductServices productServices;

    @GetMapping
    public String findAll(Model model, @RequestParam(defaultValue = "1", name = "p") Integer page){
        model.addAttribute("products", productServices.findAll(page - 1,5));
        return "products";
    }

    @GetMapping("/asc")
    public String findAllByPriceAsc(Model model) {
        model.addAttribute("products", productServices.findAllByPriceASC());
        return "productsAsc";
    }

    @GetMapping("/desc")
    public String findAllByPriceDesc(Model model){
        model.addAttribute("products", productServices.findAllByPriceDesc());
        return "productsDesc";
    }

    @GetMapping("/min_max")
    public String findMinMaxPrice(Model model){
        model.addAttribute("products", productServices.findMinMaxPriceProduct());
        return "productsMinMax";
    }
}
