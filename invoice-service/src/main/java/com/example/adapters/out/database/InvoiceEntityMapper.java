package com.example.adapters.out.database;

import com.example.core.domain.Invoice;

public interface InvoiceEntityMapper {
    static InvoiceEntity of(Invoice invoice){
        return new InvoiceEntity(
                invoice.getId(), invoice.getAmount(), CompanyEntityMapper.of(invoice.getCompany()), invoice.getCreateDate(),invoice.getDatePurchase()
        );
    }

    static Invoice of(InvoiceEntity invoiceEntity){
        return new Invoice(
                invoiceEntity.getId(), invoiceEntity.getAmount(),  CompanyEntityMapper.of(invoiceEntity.getCompany()), invoiceEntity.getCreateDate(), invoiceEntity.getDatePurchase()
        );
    }
}
