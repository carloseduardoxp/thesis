@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManagerBean;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        final String[] userEndpoints = {
            "/v1/api/airline"
        };

        final String[] adminEndpoints = {
                "/v1/api/jobs**"
            };

        http
            .requestMatchers()
                .antMatchers(userEndpoints)
                .antMatchers(adminEndpoints)
                .antMatchers("/secure/**")
                .and()
            .authorizeRequests()
                .antMatchers("/secure/**").authenticated()
                .antMatchers(userEndpoints).hasRole("USER")
                .antMatchers(adminEndpoints).hasRole("ADMIN");

        // @formatter:on
        http.addFilterBefore(new BasicAuthenticationFilter(authenticationManagerBean),
                UsernamePasswordAuthenticationFilter.class);
    }

}