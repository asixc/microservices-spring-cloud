package com.example.ports.output;

import com.example.adapters.in.api.rest.CompanyDTO;
import com.example.core.domain.Company;

public interface CompanyEntityMapper {
    static CompanyDTO of(Company company){
        return new CompanyDTO(
                company.getId(),
                company.getName(),
                company.getCreateDate()
        );
    }
    static Company of(CompanyDTO company){
        return new Company(
                company.id(),
                company.name(),
                company.created()
        );
    }
}
