package com.team4.first_ui_.flow.Controller;

import com.team4.first_ui_.flow.Model.Product;
import com.team4.first_ui_.flow.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Products")
public class ProductController {

    private final ProductService ProductService;

    public ProductController(ProductService ProductService) {
        this.ProductService = ProductService;
    }

    @GetMapping
    public String getAllProducts( Model model) {
        model.addAttribute("Products", ProductService.getAllProducts());
        return "Products";
    }
    @GetMapping("/new")
    public String showCreateForm( Model model) {
        model.addAttribute("Product", new Product());
        return "Product-form";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product Product) {
        ProductService.saveProduct(Product);
        return "redirect:/Products";
    }
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ProductService.deleteProductById(id);
        return "redirect:/Products";
    }
}
