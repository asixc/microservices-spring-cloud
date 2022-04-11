package com.example.adapters.out.database;

import com.example.core.domain.Company;
import com.example.ports.output.CompanyCRUDOutPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompanyDao implements CompanyCRUDOutPort {

    private final CompanyRepository companyRepository;

    public CompanyDao(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return this.companyRepository.findAll()
                .stream()
                .map(CompanyEntityMapper::of)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Company> findById(Long idCompany) {
        return this.companyRepository.findById(idCompany).map(CompanyEntityMapper::of);
    }

    @Override
    public Company save(Company company) {
        CompanyEntity entity = CompanyEntityMapper.of(company); //
        this.companyRepository.save(entity);
        return CompanyEntityMapper.of(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.companyRepository.deleteById(id);
    }
}
