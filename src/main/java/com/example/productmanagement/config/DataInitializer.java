package com.example.productmanagement.config;
import com.example.productmanagement.model.AppUser;
import com.example.productmanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class DataInitializer {
 @Bean CommandLineRunner init(UserRepository repo,PasswordEncoder enc){
  return args->{if(!repo.existsByEmail("admin@example.com"))repo.save(new AppUser("admin@example.com",enc.encode("123456")));
  if(!repo.existsByEmail("user@example.com"))repo.save(new AppUser("user@example.com",enc.encode("123456")));};
 }
}