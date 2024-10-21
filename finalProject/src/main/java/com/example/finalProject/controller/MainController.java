package com.example.finalProject.controller;

import com.example.finalProject.dto.MajorDTO;
import com.example.finalProject.entity.MajorEntity;
import com.example.finalProject.entity.ProductEntity;
import com.example.finalProject.repository.MajorRepository;
import com.example.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public String index(Model model) {
        int majorIdx = 1;
        List<ProductEntity> products = productService.getProductsByMajorIdx(majorIdx);
        model.addAttribute("products", products);

        List<ProductEntity> randomProducts1101 = productService.findByRefValue(1101);
        List<ProductEntity> randomProducts1102 = productService.findByRefValue(1102);
        List<ProductEntity> randomProducts1201 = productService.findByRefValue(1201);
        List<ProductEntity> randomProducts1301 = productService.findByRefValue(1301);
        List<ProductEntity> randomProducts1302 = productService.findByRefValue(1302);
        List<ProductEntity> randomProducts1401 = productService.findByRefValue(1401);
        List<ProductEntity> randomProducts1402 = productService.findByRefValue(1402);
        List<ProductEntity> randomProducts2101 = productService.findByRefValue(2101);
        List<ProductEntity> randomProducts3101 = productService.findByRefValue(3101);
        List<ProductEntity> randomProducts3102 = productService.findByRefValue(3102);

        model.addAttribute("randomProducts1101", randomProducts1101);
        model.addAttribute("randomProducts1102", randomProducts1102);
        model.addAttribute("randomProducts1201", randomProducts1201);
        model.addAttribute("randomProducts1301", randomProducts1301);
        model.addAttribute("randomProducts1302", randomProducts1302);
        model.addAttribute("randomProducts1401", randomProducts1401);
        model.addAttribute("randomProducts1402", randomProducts1402);
        model.addAttribute("randomProducts2101", randomProducts2101);
        model.addAttribute("randomProducts3101", randomProducts3101);
        model.addAttribute("randomProducts3102", randomProducts3102);

        return "main"; // main 템플릿에 제품 목록 전달
    }
}
