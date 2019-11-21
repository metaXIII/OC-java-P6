package com.metaxiii.escalade.service;

import com.metaxiii.escalade.model.Role;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    private static List<GrantedAuthority> getAuthorities(Role role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRole()));
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user
                .map((u) -> {
                    boolean enabled = true;
                    boolean accountNonExpired = true;
                    boolean credentialsNonExpired = true;
                    boolean accounNotLock = true;
                    return new org.springframework.security.core.userdetails.User(
                            u.getEmail(),
                            u.getPassword().toLowerCase(),
                            enabled,
                            accountNonExpired,
                            credentialsNonExpired,
                            accounNotLock,
                            getAuthorities(u.getRole()));
                })
                .orElseThrow(() -> new UsernameNotFoundException("Il n'existe pas d'utilisateurs avec le nom d'utilisateur " + username));
    }
}
