package com.example.Buoi5_HoangThanhHai.controller;

import com.example.Buoi5_HoangThanhHai.model.Category;
import com.example.Buoi5_HoangThanhHai.model.Product;
import com.example.Buoi5_HoangThanhHai.service.CategoryService;
import com.example.Buoi5_HoangThanhHai.service.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService,
                             CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    // ================= LIST =================
    @GetMapping
    public String listProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";
    }

    // ================= ADD =================
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/add";
    }

    // ================= SAVE =================
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {

        // Nếu chưa chọn danh mục -> quay lại form
        if (product.getCategory() == null ||
                product.getCategory().getId() == null) {
            return "redirect:/products/add";
        }

        // Lấy category từ database
        Category category = categoryService
                .getCategoryById(product.getCategory().getId());

        if (category == null) {
            return "redirect:/products/add";
        }

        product.setCategory(category);

        productService.saveProduct(product);

        return "redirect:/products";
    }

    // ================= EDIT =================
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {

        Product product = productService.getProductById(id);

        if(product == null){
            return "redirect:/products";
        }

        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "product/edit";
    }

    // ================= DELETE =================
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}