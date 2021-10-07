package com.internetshop.service;

import com.internetshop.repository.PriceRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class PriceService {
    private final PriceRepository priceRepository;
}
