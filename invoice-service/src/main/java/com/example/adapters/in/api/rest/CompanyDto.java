package com.example.adapters.in.api.rest;

import java.time.LocalDateTime;

public record CompanyDto(Long id, String name, LocalDateTime created) {
}
