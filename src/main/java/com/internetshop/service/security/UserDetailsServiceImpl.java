package com.internetshop.service.security;

import com.internetshop.entity.security.User;
import com.internetshop.security.UserDetailsImp;
import com.internetshop.repository.security.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findUserByLogin(s).orElseThrow(() -> new UsernameNotFoundException(s));
        return new UserDetailsImp(user);
    }
}
