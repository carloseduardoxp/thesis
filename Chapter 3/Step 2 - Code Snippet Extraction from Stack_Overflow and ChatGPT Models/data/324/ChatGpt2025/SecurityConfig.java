@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // enable in production with proper config
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/your-post-route").authenticated()
            .anyRequest().permitAll()
            .and()
            .httpBasic(); // or formLogin(), JWT, OAuth, etc.
    }
}
