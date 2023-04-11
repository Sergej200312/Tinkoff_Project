package org.example;

import LinkParser.LinkHandler;
import LinkParser.LinkHandler;
import OtherLink.NullLinkHandler;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Hello world!
 *
 */
@Service
public class LinkAnalysis {
    private final LinkHandler linkHandler;

    public LinkAnalysis(List<LinkHandler> linkHandlers) {
        linkHandler = new NullLinkHandler();
        LinkHandler lastHandler = linkHandler;
        for (LinkHandler handler : linkHandlers) {
            handler.setNextHandler(lastHandler);
            lastHandler = handler;
        }
    }

    public String parseLink(String link) {
        return linkHandler.handleLink(link);
    }

}
