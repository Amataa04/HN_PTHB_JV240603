package com.example.controller;

import com.example.model.entity.categories.Category;
import com.example.model.service.categories.CategoryService;
import org.apache.commons.fileupload.util.LimitedInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/index";
    }
    @GetMapping("/add")
    public String add(Model model, @ModelAttribute Category category) {
        model.addAttribute("category", category);
        return "categories/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute Category category) {
        if(categoryService.add(category)) {
            return "redirect:/categories";
        }
        return "categories/add";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @ModelAttribute Category category, @PathVariable("id") int id) {
        category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/update";
    }
    @PostMapping("/update/{id}")
    public String edit(@ModelAttribute Category category) {
        if(categoryService.update(category)) {
            return "redirect:/categories";
        }
        return "categories/update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        if(categoryService.delete(id)) {
            return "redirect:/categories";
        }
        return "categories/delete";
    }
}
