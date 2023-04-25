package StackOverflow;

import LinkParser.LinkHandler;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StackOverflowLinkHandler implements LinkHandler {
    private LinkHandler nextHandler;

    @Override
    public void setNextHandler(LinkHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public String handleLink(String link) {
        Pattern pattern = Pattern.compile("https?://stackoverflow.com/questions/([0-9]+)/?");
        Matcher matcher = pattern.matcher(link);
        if (matcher.matches()) {
            return matcher.group(1);
        } else if (nextHandler != null) {
            return nextHandler.handleLink(link);
        } else {
            return null;
        }
    }
}
