package DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ChatResponse {
    private Long id;
    private String name;
    private String description;
    private List<String> members;
}
