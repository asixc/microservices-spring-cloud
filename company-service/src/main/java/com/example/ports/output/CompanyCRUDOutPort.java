package com.example.ports.output;

import com.example.core.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyCRUDOutPort {
    List<Company> findAll();

    Optional<Company> findById(Long idCompany);

    Company save(Company company);

    void deleteById(Long id);
}
