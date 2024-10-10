package com.example.finalProject.controller;

import com.example.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WomanClothController {
    @Autowired
    private ProductService productService;

    @GetMapping("/woman")
    public String woman_cloth() {
        return "woman_cloth";
    }
}

