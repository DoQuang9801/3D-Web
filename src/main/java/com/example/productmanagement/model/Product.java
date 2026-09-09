package com.example.productmanagement.model;
import jakarta.persistence.*;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(nullable=false,unique=true) private String code;
 private String category; private double price; private int quantity; private String description;
 public Product(){}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getCode(){return code;} public void setCode(String v){code=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public double getPrice(){return price;} public void setPrice(double v){price=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
}