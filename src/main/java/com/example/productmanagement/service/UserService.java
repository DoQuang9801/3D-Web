package com.example.productmanagement.service;
import com.example.productmanagement.model.AppUser;
import com.example.productmanagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
 private final UserRepository repo; private final PasswordEncoder encoder;
 public UserService(UserRepository r,PasswordEncoder e){repo=r;encoder=e;}
 public boolean exists(String email){return repo.existsByEmail(email);}
 public void register(String email,String password){repo.save(new AppUser(email,encoder.encode(password)));}
}