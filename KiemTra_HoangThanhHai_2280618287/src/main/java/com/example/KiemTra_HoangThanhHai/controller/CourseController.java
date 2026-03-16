package com.example.KiemTra_HoangThanhHai.controller;

import com.example.KiemTra_HoangThanhHai.entity.Course;
import com.example.KiemTra_HoangThanhHai.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Hiển thị danh sách course
    @GetMapping
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }

    // CREATE
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("course", new Course());
        return "create-course";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute Course course){
        courseRepository.save(course);
        return "redirect:/admin/courses";
    }

    // UPDATE
    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model){
        Course course = courseRepository.findById(id).orElseThrow();
        model.addAttribute("course", course);
        return "edit-course";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute Course course){
        courseRepository.save(course);
        return "redirect:/admin/courses";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return "redirect:/admin/courses";
    }

}