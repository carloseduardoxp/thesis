

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        // TODO call custom service or do whatever you want 
        return null;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        // copied it from AbstractUserDetailsAuthenticationProvider
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}