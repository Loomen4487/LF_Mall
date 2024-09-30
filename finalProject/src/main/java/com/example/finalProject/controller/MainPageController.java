package com.example.finalProject.controller;

import com.example.finalProject.service.CategoryService;
import com.example.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainPageController {
    @Autowired
    private ProductService productService;

    @GetMapping("/main_menu")
    public String selectName(Model model) {
        System.out.println("결과 : "+productService.findAll());
        model.addAttribute("item",productService.findAll());
        return "main/main_menu";
    }
}
