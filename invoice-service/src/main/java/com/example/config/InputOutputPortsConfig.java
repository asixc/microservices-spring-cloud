package com.example.config;

import com.example.adapters.out.database.InvoiceDao;
import com.example.adapters.out.database.InvoiceRepository;
import com.example.core.usercases.InvoiceUseCase;
import com.example.ports.input.InvoiceCRUDInPort;
import com.example.ports.output.InvoiceCRUDOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputOutputPortsConfig {
    @Bean
    public InvoiceDao invoiceDao(InvoiceRepository repository) {
        return new InvoiceDao(repository);
    }

    @Bean
    public InvoiceCRUDInPort invoiceCrudInPort(InvoiceCRUDOutPort invoiceCRUDOutPort) {
        return new InvoiceUseCase(invoiceCRUDOutPort);
    }
}
