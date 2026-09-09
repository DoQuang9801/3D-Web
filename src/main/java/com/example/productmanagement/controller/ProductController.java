package com.example.productmanagement.controller;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/products")
public class ProductController {
 private final ProductService service; public ProductController(ProductService s){service=s;}
 @GetMapping public String list(Model m){m.addAttribute("products",service.findAll());return "products";}
 @GetMapping("/new") public String create(Model m){m.addAttribute("product",new Product());return "product-form";}
 @GetMapping("/edit/{id}") public String edit(@PathVariable Long id,Model m){Product p=service.findById(id);if(p==null)return "redirect:/products";m.addAttribute("product",p);return "product-form";}
 @PostMapping("/save") public String save(@ModelAttribute Product p){service.save(p);return "redirect:/products";}
 @GetMapping("/delete/{id}") public String delete(@PathVariable Long id){service.delete(id);return "redirect:/products";}
}