package com.example.config;

import com.example.adapters.out.database.CompanyDao;
import com.example.adapters.out.database.CompanyRepository;
import com.example.core.usercases.CompanyUseCase;
import com.example.ports.input.CompanyCRUDInPort;
import com.example.ports.output.CompanyCRUDOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputOutputPortsConfig {
    @Bean
    public CompanyDao companyDao(CompanyRepository repository) {
        return new CompanyDao(repository);
    }

    @Bean
    public CompanyCRUDInPort companyCrudInPort(CompanyCRUDOutPort companyCRUDOutPort) {
        return new CompanyUseCase(companyCRUDOutPort);
    }
}
