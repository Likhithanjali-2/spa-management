package com.springbt.spamanagement.service;


import com.springbt.spamanagement.model.User;
import com.springbt.spamanagement.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * The type User detail service.
 *
 * @author Givantha Kalansuriya @Project spring -boot-rest-api-auth-jwt-tutorial
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    /**
     * Instantiates a new User detail service.
     *
     * @param userRepository the user repository
     */
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userDetails = userRepository.findByUsername(username);
        if(userDetails == null){
            throw new UsernameNotFoundException(username);
        }
        Collection<? extends GrantedAuthority> authorities
                = Arrays.asList("admin".split(",")).stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(userDetails.getUsername(),userDetails.getPassword(), authorities);
    }
}