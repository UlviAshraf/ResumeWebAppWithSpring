package com.company.service;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user != null) {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.password(user.getPassword());
            builder.disabled(false);
            String[] authotoriesArr = new String[]{"ADMIN", "USER"};
            builder.authorities(authotoriesArr);
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
