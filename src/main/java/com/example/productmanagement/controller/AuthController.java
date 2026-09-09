package com.example.productmanagement.controller;
import com.example.productmanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class AuthController {
 private final UserService service; public AuthController(UserService s){service=s;}
 @GetMapping("/") public String home(){return "redirect:/dashboard";}
 @GetMapping("/signin") public String signin(){return "signin";}
 @GetMapping("/signup") public String signup(){return "signup";}
 @PostMapping("/signup") public String register(@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword){
  if(password.length()<6||!password.equals(confirmPassword)||service.exists(email))return "redirect:/signup?error=true";
  service.register(email,password); return "redirect:/signin?registered=true";
 }
}