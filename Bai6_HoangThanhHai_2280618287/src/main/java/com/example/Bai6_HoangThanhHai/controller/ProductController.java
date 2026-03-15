package com.example.Bai6_HoangThanhHai.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String getProducts(){
        return "Danh sach san pham";
    }

    @GetMapping("/add")
    public String addProduct(){
        return "Them san pham (ADMIN)";
    }

}