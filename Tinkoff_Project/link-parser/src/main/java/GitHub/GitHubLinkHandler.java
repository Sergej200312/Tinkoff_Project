package GitHub;

import LinkParser.LinkHandler;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GitHubLinkHandler implements LinkHandler {
    private LinkHandler nextHandler;

    @Override
    public void setNextHandler(LinkHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public String handleLink(String link) {
        Pattern pattern = Pattern.compile("https?://github.com/([^/]+)/([^/]+)/?");
        Matcher matcher = pattern.matcher(link);
        if (matcher.matches()) {
            String username = matcher.group(1);
            String repository = matcher.group(2);
            return username + "/" + repository;
        } else if (nextHandler != null) {
            return nextHandler.handleLink(link);
        } else {
            return null;
        }
    }
}