package com.example.productmanagement.config;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
  http.csrf(csrf -> csrf.disable())
  .authorizeHttpRequests(a->a.requestMatchers("/signin","/signup","/css/**","/api/**").permitAll().anyRequest().authenticated())
  .formLogin(f->f.loginPage("/signin").defaultSuccessUrl("/dashboard",true).failureUrl("/signin?error=true").permitAll())
  .logout(l->l.logoutUrl("/signout").logoutSuccessUrl("/signin?logout=true").invalidateHttpSession(true).deleteCookies("JSESSIONID"))
  .sessionManagement(s->s.invalidSessionUrl("/signin?expired=true").maximumSessions(1));
  return http.build();
 }
}