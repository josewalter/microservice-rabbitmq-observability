package com.msobservabilite.microservice_observabilite_user;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserRecordDto(@NotBlank String name, @NotBlank String email) {
}
