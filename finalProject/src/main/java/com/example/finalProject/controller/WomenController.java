package com.example.finalProject.controller;

import com.example.finalProject.service.CategoryService;
import com.example.finalProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WomenController {
    private final ProductService productService;
    private final CategoryService categoryService;
    @GetMapping(value = "/women")
    public String login(Model model){
        model.addAttribute("item",productService.selectIdx(1));
        model.addAttribute("dto",categoryService.selectMajor("여성의류"));
        return "women";
    }
}
