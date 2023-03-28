package controller;

import java.util.ArrayList;

public class LinkService {
    private ArrayList<LinkResponse> links = new ArrayList<>();

    public ArrayList<LinkResponse> getAllLinks() {
        return links;
    }

    public void addLink(LinkResponse link) {
        links.add(link);
    }

    public boolean deleteLink(Long id) {
        for (LinkResponse link : links) {
            if (link.getId().equals(id)) {
                links.remove(link);
                break;
            }
        }
        return false;
    }
}
