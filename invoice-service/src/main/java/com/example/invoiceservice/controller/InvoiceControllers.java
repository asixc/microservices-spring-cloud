package com.example.invoiceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceControllers {

    @GetMapping
    public String getInvoices() {
        return "Invoices...";
    }
}

