package com.internetshop.repository.security;

import com.internetshop.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{
    Optional<User> findUserByLogin(String login);
}
