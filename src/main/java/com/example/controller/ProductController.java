package com.example.controller;

import com.example.model.entity.categories.Category;
import com.example.model.entity.products.Product;
import com.example.model.service.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/index";
    }
    @GetMapping("/add")
    public String add(Model model, @ModelAttribute Product product) {
        model.addAttribute("product", product);
        return "product/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute Product product) {
        if(productService.add(product)) {
            return "redirect:/product";
        }
        return "product/add";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @ModelAttribute Product product, @PathVariable("id") int id) {
        product = productService.findById(id);
        model.addAttribute(" product",  product);
        return "product/update";
    }
    @PostMapping("/update/{id}")
    public String edit(@ModelAttribute Product product) {
        if(productService.update(product)) {
            return "redirect:/product";
        }
        return "product/update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        if(productService.delete(id)) {
            return "redirect:/product";
        }
        return "product/delete";
    }
}