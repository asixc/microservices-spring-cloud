package com.example.core.usercases;

import com.example.core.domain.Company;
import com.example.ports.input.CompanyCRUDInPort;
import com.example.ports.output.CompanyCRUDOutPort;

import java.util.List;
import java.util.Optional;

public class CompanyUseCase implements CompanyCRUDInPort {

    private final CompanyCRUDOutPort companyOutPort;

    public CompanyUseCase(CompanyCRUDOutPort companyOutPort) {
        this.companyOutPort = companyOutPort;
    }

    @Override
    public List<Company> findAll() {
        return this.companyOutPort.findAll();
    }

    @Override
    public Optional<Company> findById(Long idCompany) {
        return this.companyOutPort.findById(idCompany);
    }

    @Override
    public Company save(Company company) {
        return this.companyOutPort.save(company);
    }

    @Override
    public Company update(Company company) {
        Optional<Company> lastCompany = this.companyOutPort.findById(company.getId());
        lastCompany.ifPresent((c) -> company.setId(c.getId()));

        return this.save(company);
    }

    @Override
    public void deleteById(Long id) {

    }
}
