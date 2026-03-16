package com.example.KiemTra_HoangThanhHai.controller;

import com.example.KiemTra_HoangThanhHai.entity.Course;
import com.example.KiemTra_HoangThanhHai.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page) {

        Page<Course> coursePage = courseRepository.findAll(PageRequest.of(page, 5));

        model.addAttribute("courses", coursePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", coursePage.getTotalPages());

        return "home";
    }
}