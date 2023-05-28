package DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ChatRequest {
    private String name;
    private String description;
    private List<String> members;
}
