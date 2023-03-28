package DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ChatResponse {
    private String name;
    private ArrayList<String> users;

    private Long id;

}
