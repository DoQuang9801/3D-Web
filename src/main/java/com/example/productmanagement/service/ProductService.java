package com.example.productmanagement.service;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
 private final ProductRepository repo;
 public ProductService(ProductRepository r){repo=r;}
 public List<Product> findAll(){return repo.findAll();}
 public Product findById(Long id){return repo.findById(id).orElse(null);}
 public Product save(Product p){return repo.save(p);}
 public void delete(Long id){repo.deleteById(id);}
 public long count(){return repo.count();}
}