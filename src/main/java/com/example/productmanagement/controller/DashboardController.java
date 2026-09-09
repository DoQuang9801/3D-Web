package com.example.productmanagement.controller;
import com.example.productmanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DashboardController {
 private final ProductService service; public DashboardController(ProductService s){service=s;}
 @GetMapping("/dashboard") public String dashboard(Model m){m.addAttribute("productCount",service.count());return "dashboard";}
}