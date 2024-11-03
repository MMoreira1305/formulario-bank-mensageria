package com.example.mensageria_kafka.dto;

import jakarta.annotation.Nonnull;

public record EmailDTO(@Nonnull String email, @Nonnull String message, @Nonnull String token){
}
