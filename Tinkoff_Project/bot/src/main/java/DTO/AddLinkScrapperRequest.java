package DTO;

import lombok.Builder;
import org.hibernate.validator.constraints.URL;

import java.net.URI;

@Builder
public record AddLinkScrapperRequest(
        @URL
        URI link
) {
}
