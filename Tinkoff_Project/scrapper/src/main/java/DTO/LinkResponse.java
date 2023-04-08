package DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

    public record LinkResponse(
            long id,
            String url
    ) {
    }

