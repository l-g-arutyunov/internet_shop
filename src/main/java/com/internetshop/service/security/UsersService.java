package com.internetshop.service.security;

import com.internetshop.entity.security.User;
import com.internetshop.security.UserDetailsImp;
import com.internetshop.repository.security.UsersRepository;
import com.sun.xml.bind.v2.TODO;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
public class UsersService {

    private final UsersRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
        return userDetails.getUser();
    }

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User getUserById(Long id) {
       return repository.findById(id).get(); //TODO
    }

    public boolean deleteUser(Long id) {
        try {
            repository.delete(getUserById(id));
            return true;
        } catch (Exception e) { //TODO
            e.printStackTrace();
            return false;
        }

    }
}
