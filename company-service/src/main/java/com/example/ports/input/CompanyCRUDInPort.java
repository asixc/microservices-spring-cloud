package com.example.ports.input;

import com.example.core.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyCRUDInPort {
    List<Company> findAll();

    Optional<Company> findById(Long idCompany);

    Company save(Company company);

    Company update(Company company);

    void deleteById(Long id);
}
