package com.example.adapters.in.api.rest;

import com.example.core.domain.Company;

public interface CompanyRestMapper {
    static CompanyDto of(Company company){
        return new CompanyDto(
                company.getId(), company.getName(), company.getCreateDate()
        );
    }

    static Company of(CompanyDto companyDto){
        return new Company(
                companyDto.id(), companyDto.name(), companyDto.created()
        );
    }
}
