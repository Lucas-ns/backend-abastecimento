package com.dimensionalengenharia.backend.exceptions;

import java.time.LocalDateTime;

public record ErrorMessage(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String message
) {
}
