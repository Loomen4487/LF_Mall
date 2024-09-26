package com.example.finalProject.controller;

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

    @GetMapping(value = "/women/{major}")
    public String women(@PathVariable String major, Model model){
        //model.addAttribute("item",productService.selectIdx(1));
        model.addAttribute("dto",categoryService.selectMajor(major));
        HashMap<String, Object> map = productService.selectMajor(major);
        model.addAttribute("title",major);
        model.addAttribute("major",major);
        model.addAttribute("category",map.get("category"));
        model.addAttribute("item",map.get("list"));
        return "women";
    }

    @GetMapping(value = "/women/{major}/{middle}")
    public String women(@PathVariable String major, @PathVariable String middle, Model model){
        //model.addAttribute("item",productService.selectIdx(1));
        model.addAttribute("dto",categoryService.selectMajor(major));
        HashMap<String, Object> map = productService.selectMiddle(major,middle);
        model.addAttribute("title",middle);
        model.addAttribute("major",major);
        model.addAttribute("middle",middle);
        model.addAttribute("category",map.get("category"));
        model.addAttribute("item",map.get("list"));
        return "women";
    }

    @GetMapping(value = "/women/{major}/{middle}/{sub}")
    public String women(@PathVariable String major, @PathVariable String middle, @PathVariable String sub, Model model){
        //model.addAttribute("item",productService.selectIdx(1));
        model.addAttribute("dto",categoryService.selectMajor(major));
        HashMap<String, Object> map = productService.selectMiddle(major,middle);
        model.addAttribute("title",middle);
        model.addAttribute("major",major);
        model.addAttribute("middle",middle);
        model.addAttribute("sub",sub);
        model.addAttribute("category",map.get("category"));
        model.addAttribute("item",productService.selectSub(major,middle,sub));
        return "women";
    }

}
