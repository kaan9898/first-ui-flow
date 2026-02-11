package com.team4.first_ui_.flow.Controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;import com.team4.first_ui_.flow.Model.Product;
import com.team4.first_ui_.flow.Service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequestMapping("/Products")
public class ProductController {

    private final ProductService ProductService;

    public ProductController(ProductService ProductService) {
        this.ProductService = ProductService;
    }

    @GetMapping
    public String getAllProducts(Model model, Principal principal, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Page<Product> productPage = ProductService.getProductsPage(page, pageSize);

        model.addAttribute("Products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());

        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }

        return "Products";
    }

    @GetMapping("/new")
    public String showCreateForm( Model model) {
        model.addAttribute("Product", new Product());
        return "Product-form";
    }


    @PostMapping("/saveProduct")
    public String saveProduct(
            @Valid @ModelAttribute("Product") Product product,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "Product-form";
        }

        ProductService.saveProduct(product);
        return "redirect:/Products";
    }
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ProductService.deleteProductById(id);
        return "redirect:/Products";
    }
}
