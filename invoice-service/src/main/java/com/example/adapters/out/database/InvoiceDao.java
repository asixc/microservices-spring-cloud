package com.example.adapters.out.database;

import com.example.core.domain.Invoice;
import com.example.ports.output.InvoiceCRUDOutPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceDao implements InvoiceCRUDOutPort {

    private final InvoiceRepository invoiceRepository;

    public InvoiceDao(InvoiceRepository companyRepository) {
        this.invoiceRepository = companyRepository;
    }

    @Override
    public List<Invoice> findAll() {
        return this.invoiceRepository.findAll()
                .stream()
                .map(InvoiceEntityMapper::of)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Invoice> findById(Long invoiceId) {
        return this.invoiceRepository.findById(invoiceId).map(InvoiceEntityMapper::of);
    }

    @Override
    public Invoice save(Invoice company) {
        InvoiceEntity entity = InvoiceEntityMapper.of(company); //
        this.invoiceRepository.save(entity);
        return InvoiceEntityMapper.of(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.invoiceRepository.deleteById(id);
    }
}
