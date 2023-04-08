package controller;

import DTO.LinkResponse;

import java.util.ArrayList;

public class LinkService {
    private ArrayList<LinkResponse> links = new ArrayList<>();

    public ArrayList<LinkResponse> getAllLinks() {
        return links;
    }

    public void addLink(LinkResponse link) {
        links.add(link);
    }



}
