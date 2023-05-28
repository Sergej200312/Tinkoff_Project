package DTO;

import jakarta.validation.constraints.NotBlank;

public record RemoveLinkRequest(
        @NotBlank
        String link
) {
}