package com.example.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Invoice {
    private Long id;
    private BigDecimal amount;
    private Company company;
    private LocalDateTime createDate;
    private LocalDateTime datePurchase;

    public Invoice() {}

    public Invoice(Long id, BigDecimal amount, Company company, LocalDateTime createDate,  LocalDateTime datePurchase) {
        this.id = id;
        this.amount = amount;
        this.company = company;
        this.createDate = createDate;
        this.datePurchase = datePurchase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDateTime datePurchase) {
        this.datePurchase = datePurchase;
    }
}
