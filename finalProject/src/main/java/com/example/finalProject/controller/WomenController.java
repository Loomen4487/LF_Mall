package com.example.finalProject.controller;

import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.service.CategoryService;
import com.example.finalProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class WomenController {
    private final ProductService productService;
    private final CategoryService categoryService;
    @GetMapping(value = "/women")
    public String women(Model model){
        model.addAttribute("item",productService.selectIdx(1));
        model.addAttribute("dto",categoryService.selectMajor("여성의류"));
        return "women";
    }

    @GetMapping(value = "/women/{idx}")
    public String wo(@PathVariable int idx,Model model){
        model.addAttribute("item",productService.findByRef(idx));
        model.addAttribute("major",productService.findMajor());
        model.addAttribute("middle",productService.findMiddle(idx));
        if(idx>1000){
            model.addAttribute("panel",productService.findSub(idx));
        }else{
            model.addAttribute("panel",productService.findMiddle(idx));
        }
        return "women";
    }
}
