package com.example.ports.input;

import com.example.core.domain.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceCRUDInPort {
    List<Invoice> findAll();

    Optional<Invoice> findById(Long idCompany);

    Invoice save(Invoice company);

    Invoice update(Invoice company);

    void deleteById(Long id);
}
