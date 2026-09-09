package com.example.productmanagement.controller;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/products")
public class ProductRestController {
 private final ProductService service; public ProductRestController(ProductService s){service=s;}
 @GetMapping public List<Product> all(){return service.findAll();}
 @GetMapping("/{id}") public Product one(@PathVariable Long id){return service.findById(id);}
 @PostMapping public Product create(@RequestBody Product p){return service.save(p);}
 @PutMapping("/{id}") public Product update(@PathVariable Long id,@RequestBody Product p){p.setId(id);return service.save(p);}
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id){service.delete(id);}
}