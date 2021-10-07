package com.internetshop.service;

import com.internetshop.entity.Nomenclature;
import com.internetshop.repository.NomenclatureRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class NomenclatureService {
    private final NomenclatureRepository nomenclatureRepository;

    public Nomenclature addNomenclature(Nomenclature nomenclature) {
        if (nomenclature == null) {
            return null;
        }
        return nomenclatureRepository.save(nomenclature);
    }
}
