import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for stateless APIs (JWT)
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/api/secure-post").authenticated() // Require authentication for this POST route
                .requestMatchers(HttpMethod.POST, "/api/admin-post").hasRole("ADMIN") // Require ADMIN role for this POST route
                .anyRequest().permitAll() // Allow all other requests
            )
            .httpBasic(); // Or .formLogin() or .oauth2ResourceServer().jwt()
        return http.build();
    }
}
