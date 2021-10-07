package com.internetshop.repository;

import com.internetshop.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceRepository, Long> {
}
