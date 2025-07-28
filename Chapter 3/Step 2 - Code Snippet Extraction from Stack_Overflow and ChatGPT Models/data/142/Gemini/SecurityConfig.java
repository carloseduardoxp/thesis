

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/error").permitAll() // Allow access to home and error pages
                    .anyRequest().authenticated() // All other requests require authentication
            )
            .oauth2Login(oauth2Login ->
                oauth2Login
                    .loginPage("/oauth2/authorization/google") // Custom login page if needed, otherwise Spring will generate one
                    .defaultSuccessUrl("/secured", true) // Redirect after successful login
            )
            .formLogin(withDefaults()); // Keep form login enabled for demonstration, or remove if only OAuth2

        return http.build();
    }
}
