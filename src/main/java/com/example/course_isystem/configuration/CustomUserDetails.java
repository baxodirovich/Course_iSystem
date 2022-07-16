package com.example.course_isystem.configuration;

import com.example.course_isystem.model.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter

public class CustomUserDetails implements UserDetails {
    private final Integer id;
    private final String userName;
    private final String password;
    private final Boolean enabled;

    private final List<GrantedAuthority> roleList;

    public CustomUserDetails(Users users){
        this.id = users.getId();
        this.userName = users.getName();
        this.password = users.getPassword();
        this.enabled = users.getStatus();
        this.roleList = List.of(new SimpleGrantedAuthority(users.getUserTypes().getName()));
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
