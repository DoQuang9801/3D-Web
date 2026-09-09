package com.example.productmanagement.service;
import com.example.productmanagement.model.AppUser;
import com.example.productmanagement.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
 private final UserRepository repo;
 public CustomUserDetailsService(UserRepository r){repo=r;}
 public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException{
  AppUser u=repo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Không tìm thấy tài khoản"));
  return User.withUsername(u.getEmail()).password(u.getPassword()).roles("USER").build();
 }
}