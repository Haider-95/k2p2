package se.trixzta.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/registerSubmit").permitAll()
                        .requestMatchers("/").hasAnyRole("USER", "ADMIN","MANAGER")
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN","MANAGER")
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN","MANAGER")
                        .requestMatchers("/manager/**").hasAnyRole("MANAGER")
                        .requestMatchers("/error/**").hasAnyRole("ADMIN","MANAGER","USER")

                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .logout((logout) -> logout
                .logoutUrl("/logout")
              // Dirigera till startsidan efter utloggning
                .permitAll()
        );

        // .httpBasic(Customizer.withDefaults());
        return http.build();
    }

}
