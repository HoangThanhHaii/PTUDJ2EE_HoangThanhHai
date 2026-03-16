package com.example.KiemTra_HoangThanhHai.controller;

import com.example.KiemTra_HoangThanhHai.entity.Student;
import com.example.KiemTra_HoangThanhHai.entity.StudentRole;
import com.example.KiemTra_HoangThanhHai.repository.StudentRepository;
import com.example.KiemTra_HoangThanhHai.repository.StudentRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentRoleRepository studentRoleRepository;

    // Hiển thị form đăng ký
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    // Xử lý đăng ký
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {

        // Lưu student vào bảng student
        Student savedStudent = studentRepository.save(student);

        // Tạo role cho student
        StudentRole studentRole = new StudentRole();
        studentRole.setStudent_id(savedStudent.getStudent_id());
        studentRole.setRole_id(2L); // 2 = STUDENT

        // Lưu vào bảng student_role
        studentRoleRepository.save(studentRole);

        // Sau khi đăng ký → chuyển về login
        return "redirect:/login";
    }
}