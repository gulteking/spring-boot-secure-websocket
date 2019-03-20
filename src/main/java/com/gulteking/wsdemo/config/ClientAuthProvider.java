package com.gulteking.wsdemo.config;

import com.gulteking.wsdemo.exception.ExceptionMessages;
import com.gulteking.wsdemo.exception.InvalidLoginException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientAuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<GrantedAuthority> userRoleList = new ArrayList<>();
        userRoleList.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (username.equalsIgnoreCase("user1") && password.equals("123456")) {
            return new UsernamePasswordAuthenticationToken(username, password, userRoleList);
        } else if (username.equalsIgnoreCase("user2") && password.equals("123456")) {
            return new UsernamePasswordAuthenticationToken(username, password, userRoleList);
        }

        throw new InvalidLoginException(ExceptionMessages.INVALID_USERNAME_OR_PASSWORD);
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
