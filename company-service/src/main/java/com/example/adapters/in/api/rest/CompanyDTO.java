package com.example.adapters.in.api.rest;

import java.time.LocalDateTime;

public record CompanyDTO(Long id, String name, LocalDateTime created) {
}
