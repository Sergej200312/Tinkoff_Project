package OtherLink;

import LinkParser.LinkHandler;
import org.springframework.stereotype.Component;

@Component
public class NullLinkHandler implements LinkHandler {
    @Override
    public void setNextHandler(LinkHandler nextHandler) {
        // do nothing
    }

    @Override
    public String handleLink(String link) {
        return null;
    }
}