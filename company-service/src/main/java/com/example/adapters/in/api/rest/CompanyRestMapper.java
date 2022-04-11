package com.example.adapters.in.api.rest;

import com.example.core.domain.Company;

public interface CompanyRestMapper {
    static CompanyDTO of(Company company){
        return new CompanyDTO(
                company.getId(), company.getName(), company.getCreateDate()
        );
    }

    static Company of(CompanyDTO companyDto){
        return new Company(
                companyDto.id(), companyDto.name(), companyDto.created()
        );
    }
}
