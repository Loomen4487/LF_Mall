package com.example.finalProject.controller;

import com.example.finalProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainPageController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/main_menu")
    public List<String> selectName(@RequestParam String name) {
        return categoryService.selectName(name);
    }
}
