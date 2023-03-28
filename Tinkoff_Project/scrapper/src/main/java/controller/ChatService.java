package controller;

import java.util.ArrayList;

public class ChatService {
    private ArrayList<ChatResponse> chats = new ArrayList<>();

    public boolean deleteChat(Long id) {
        ChatResponse chatToDelete = null;
        for (ChatResponse chat : chats) {
            if (chat.getId().equals(id)) {
                chatToDelete = chat;
                break;
            }
        }
        if (chatToDelete == null) {
            return false;
        }
        chats.remove(chatToDelete);
        return true;
    }
}
