package com.internetshop.service;

import com.internetshop.repository.CartRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
public class CartService {
    private final CartRepository cartRepository;
}
