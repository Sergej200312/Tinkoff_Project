package DTO;


import jakarta.validation.constraints.NotBlank;

public record AddLinkRequest(
            @NotBlank
            String link
    ) {
    }
