package com.example.ports.output;

import com.example.adapters.in.api.rest.CompanyRestMapper;
import com.example.adapters.in.api.rest.InvoiceDto;
import com.example.core.domain.Invoice;

public interface InvoiceEntityMapper {
    static InvoiceDto of(Invoice invoice){
        return new InvoiceDto(
                invoice.getId(),
                invoice.getAmount(),
                CompanyRestMapper.of(invoice.getCompany()),
                invoice.getCreateDate(),
                invoice.getDatePurchase()
        );
    }
    static Invoice of(InvoiceDto invoice){
        return new Invoice(
                invoice.id(),
                invoice.amount(),
                CompanyRestMapper.of(invoice.company()),
                invoice.created(),
                invoice.datePurchase()
        );
    }
}
