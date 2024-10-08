package com.example.finalProject.controller;

import com.example.finalProject.dto.MiddleDTO;
import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.repository.MiddleRepository;
import com.example.finalProject.service.CategoryService;
import com.example.finalProject.service.MajorService;
import com.example.finalProject.service.MiddleService;
import com.example.finalProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("idx",idx);
        if(idx>1000){
            model.addAttribute("sub_name",middleService.selectByMiddleRef(idx));
        }else if(idx>100){
            model.addAttribute("sub_name",middleService.selectByRef(idx));
        }
        if(idx>100){
            model.addAttribute("panel",productService.findSub(idx));
            System.out.println("productService.findSub : "+productService.findSub(idx));
        }else {
                List<MiddleDTO> middle = productService.findMiddle(idx);
                middle.forEach(item->{
                    int na = item.getRef()%10;
                    item.setRef(major*1000+na*100+1);
                });
                model.addAttribute("panel",middle);

        }
        model.addAttribute("title",majorService.findByRef(major));
        return "women";
    }

    @GetMapping(value = "/womenSelectAll")
    @ResponseBody
    public ResponseEntity<?> womenListAll(@RequestParam(required = false) HashMap<String,String> map){
        int major_idx = map.get("major_idx")!=null?Integer.parseInt(map.get("major_idx")):0;
        int middle_idx = map.get("middle_idx")!=null?Integer.parseInt(map.get("middle_idx")):0;
        int ref = map.get("ref")!=null?Integer.parseInt(map.get("ref")):0;
        int pageSize = Integer.parseInt(map.get("pageSize"));
        return ResponseEntity.status(HttpStatus.OK).body(productService.findWomenListAll(major_idx,middle_idx,ref,pageSize*10));
    }

    // 검색 기능
    @GetMapping(value = "/women/search/{name}")
    public String search(@PathVariable String name,Model model){
        model.addAttribute("product",productService.findWomenSearchList(name));
        model.addAttribute("name",name);
        return "women2";
    }

    // 최근 본 상품
    @GetMapping(value = "/viewProduct/{idx}")
    @ResponseBody
    public ResponseEntity<ProductDTO> viewProduct(@PathVariable int idx){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findByIdx(idx));
    }
}
