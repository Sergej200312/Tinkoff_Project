package GitHub;

import LinkParser.LinkParser;

public class GitHubParser implements LinkParser {
    private LinkParser nextParser;

    @Override
    public String parse(String url) {
        if (url.matches("https://github.com/.*/.*")) {
            String[] split = url.split("/");
            return split[3] + "/" + split[4];
        } else {
            return nextParser.parse(url);
        }
    }
    @Override
    public void setNextParser(LinkParser parser) {
        nextParser = parser;
    }
}
