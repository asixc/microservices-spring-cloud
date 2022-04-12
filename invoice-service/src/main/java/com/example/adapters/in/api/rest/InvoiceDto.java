package com.example.adapters.in.api.rest;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InvoiceDto(
        Long id,
        BigDecimal amount,
        CompanyDto company,
        LocalDateTime created,
        @NotNull(message = "Date of purchase is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @PastOrPresent(message = "Incorrect Date")
        LocalDateTime datePurchase) {
}
