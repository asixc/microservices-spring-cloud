package com.example.core.usercases;

import com.example.core.domain.Invoice;
import com.example.ports.input.InvoiceCRUDInPort;
import com.example.ports.output.InvoiceCRUDOutPort;

import java.util.List;
import java.util.Optional;

public class InvoiceUseCase implements InvoiceCRUDInPort {

    private final InvoiceCRUDOutPort companyOutPort;

    public InvoiceUseCase(InvoiceCRUDOutPort companyOutPort) {
        this.companyOutPort = companyOutPort;
    }

    @Override
    public List<Invoice> findAll() {
        return this.companyOutPort.findAll();
    }

    @Override
    public Optional<Invoice> findById(Long idCompany) {
        return this.companyOutPort.findById(idCompany);
    }

    @Override
    public Invoice save(Invoice company) {
        return this.companyOutPort.save(company);
    }

    @Override
    public Invoice update(Invoice company) {
        Optional<Invoice> lastCompany = this.companyOutPort.findById(company.getId());
        lastCompany.ifPresent((c) -> company.setId(c.getId()));

        return this.save(company);
    }

    @Override
    public void deleteById(Long id) {

    }
}
