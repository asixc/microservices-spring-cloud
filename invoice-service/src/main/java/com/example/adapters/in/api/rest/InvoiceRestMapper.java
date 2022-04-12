package com.example.adapters.in.api.rest;

import com.example.core.domain.Invoice;

public interface InvoiceRestMapper {
    static InvoiceDto of(Invoice invoice){
        return new InvoiceDto(
                invoice.getId(), invoice.getAmount(), CompanyRestMapper.of(invoice.getCompany()), invoice.getCreateDate(), invoice.getDatePurchase()
        );
    }

    static Invoice of(InvoiceDto invoiceDto){
        return new Invoice(
                invoiceDto.id(), invoiceDto.amount(), CompanyRestMapper.of(invoiceDto.company()), invoiceDto.created(), invoiceDto.datePurchase()
        );
    }
}
