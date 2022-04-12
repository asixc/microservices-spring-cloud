package com.example.adapters.in.api.rest;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record CompanyDTO(Long id, @NotBlank(message = "Name is mandatory") String name, LocalDateTime created) {
}
