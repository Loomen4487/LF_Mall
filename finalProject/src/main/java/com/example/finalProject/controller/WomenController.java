package com.example.finalProject.controller;

import com.example.finalProject.dto.MiddleDTO;
import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.repository.MiddleRepository;
import com.example.finalProject.service.CategoryService;
import com.example.finalProject.service.MajorService;
import com.example.finalProject.service.MiddleService;
import com.example.finalProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class WomenController {
    private final ProductService productService;
    private final MajorService majorService;
    private final CategoryService categoryService;
    private final MiddleService middleService;
    @GetMapping(value = "/women")
    public String women(Model model){
        model.addAttribute("item",productService.selectIdx(1));
        model.addAttribute("dto",categoryService.selectMajor("여성의류"));
        return "women";
    }

    @GetMapping(value = "/women/{idx}")
    public String wo(@PathVariable int idx,Model model){
        int major = idx>1000?idx/1000:(idx>100?idx/100:idx);
        List<MiddleDTO> middleDTO = productService.findMiddle(idx);
        model.addAttribute("item",productService.findByRef(idx));
        model.addAttribute("major",productService.findMajor());
        model.addAttribute("middle",middleDTO);
        if(idx>1000){
            model.addAttribute("panel",productService.findSub(idx));
        }else{
            List<MiddleDTO> middle = productService.findMiddle(idx);
                middle.forEach(item->{
                    int na = item.getRef()%10;
                    item.setRef(1000+na*100+1);
                });
            model.addAttribute("panel",middle);

        }
        model.addAttribute("title",majorService.findByRef(major));
        return "women";
    }
}
