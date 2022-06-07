package com.example.demo.security;

import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;
 import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private CustomerRepository userRepository;

    public CustomUserDetailsService(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = (Customer) userRepository.findByUsernameOrEmail(username, username)
               .orElseThrow(() ->
                       new UsernameNotFoundException("User not found with username or email:" + username));
        return new org.springframework.security.core.userdetails.User(user.getFirstname(),
                user.getLastname(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
