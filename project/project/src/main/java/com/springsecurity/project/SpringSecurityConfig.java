package com.springsecurity.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig 
{
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(registry->{
        	registry.requestMatchers("/home").permitAll();
        	registry.requestMatchers("/admin/**").hasRole("ADMIN");
        	registry.requestMatchers("/user/**").hasRole("USER");
        	registry.anyRequest().authenticated();
        })
        	.httpBasic(Customizer.withDefaults())

         .build();		

    }
	
  @Bean
  public UserDetailsService userDetailsService() {

	UserDetails user= User.builder()
              .username("mukesh")
              .password("$2a$10$YXScbViZ5DFVOX4tZizJQeiX/s52ma4zJsl7diooLi4MdlLELyRMi")
              .roles("USER")
              .build();

	UserDetails admin = User.builder()
              .username("admin")
              .password("$2a$10$IFj0TwYOSPMvxxiLDN4TvenScP1T3JCvDibA3aaQc61X7weLhreMK")
              .roles("ADMIN","USER")
              .build();
	
      return new InMemoryUserDetailsManager(user,admin);
      
      
  }
  
 @Bean 
 public PasswordEncoder passwordEncoder()
 {
	 return new BCryptPasswordEncoder();
 }
}
