package com.gulteking.wsdemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ClientSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ClientAuthProvider clientAuthProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/*", "/v2/**", "/swagger-ui.html" ).permitAll()
                .antMatchers("/api/**").authenticated()
                .and().httpBasic()
                .and()
                .cors().disable();

        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(clientAuthProvider);
        super.configure(auth);
    }
}
