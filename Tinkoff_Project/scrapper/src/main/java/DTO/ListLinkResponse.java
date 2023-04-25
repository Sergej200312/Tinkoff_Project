package DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListLinkResponse {
    public record ListLinksResponse(
            List<LinkResponse> links,
            int size
    ) {
    }

}
