package com.example.course_isystem.configuration;

import com.example.course_isystem.util.Roles;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private CustomUserDetailsService customUserDetailsService;
    private JwtTokenFilter jwtTokenFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailsService);
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("role_admin")
                .and()
                .withUser("user").password("{noop}user").roles(Roles.ROLE_USER.name().toLowerCase());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable();

        http.authorizeHttpRequests()
                .antMatchers("/classes/**").permitAll()
                .antMatchers("/course/**").permitAll()
                .antMatchers("/group/**").permitAll()
                .antMatchers("/group-types/**").permitAll()
                .antMatchers("/rooms/**").permitAll()
                .antMatchers("/teacher/**").permitAll()
                .antMatchers("/teacher-types/**").permitAll()
                .antMatchers("/user-groups/**").permitAll()
                .antMatchers("/user-image/**").permitAll()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/user-types/**").permitAll()
                .antMatchers("/attendance-type/**").permitAll();

        http.addFilterBefore(
                jwtTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
