package com.example.finalProject.service;

import com.example.finalProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<String> selectMajor(String major) {
        List<String> li = categoryRepository.selectMajor(major);
        return li;
    }
}
