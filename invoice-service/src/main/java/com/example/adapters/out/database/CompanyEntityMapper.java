package com.example.adapters.out.database;

import com.example.core.domain.Company;

public interface CompanyEntityMapper {
    static CompanyEntity of(Company company){
        return new CompanyEntity(
                company.getId(), company.getName(), company.getCreateDate()
        );
    }

    static Company of(CompanyEntity companyEntity){
        return new Company(
                companyEntity.getId(), companyEntity.getName(), companyEntity.getCreateDate()
        );
    }
}
