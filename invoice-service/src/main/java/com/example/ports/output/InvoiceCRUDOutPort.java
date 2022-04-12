package com.example.ports.output;

import com.example.core.domain.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceCRUDOutPort {
    List<Invoice> findAll();

    Optional<Invoice> findById(Long idCompany);

    Invoice save(Invoice company);

    void deleteById(Long id);
}
