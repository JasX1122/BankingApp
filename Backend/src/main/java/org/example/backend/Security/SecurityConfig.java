package org.example.backend.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/GetValues/**").permitAll()
                                .requestMatchers("/GetValues/byEmail/**").permitAll()
                                .requestMatchers("/GetValues/IdByEmail/**").permitAll()
                                .requestMatchers("/api/clients/**").hasRole("USER")
                                .requestMatchers("/accounts/**").permitAll()
                                .requestMatchers("/accounts/number/**").permitAll()
                                .requestMatchers("/api/accounts/**").hasRole("USER")
                                .requestMatchers("accounts/deposit").permitAll()
                                .requestMatchers("accounts/withdraw").permitAll()
                                .requestMatchers("/accounts/transfer").permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity; consider enabling it for production

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}