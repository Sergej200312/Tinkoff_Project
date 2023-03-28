package StackOverflow;

import LinkParser.LinkParser;

public class StackOverflowParser implements LinkParser {
    private LinkParser nextParser;

    @Override
    public String parse(String url) {
        if (url.matches("https://stackoverflow.com/questions/\\d+.*")) {
            String[] split = url.split("/");
            return split[4];
        } else {
            return nextParser.parse(url);
        }
    }

    @Override
    public void setNextParser(LinkParser parser) {
        nextParser = parser;
    }

}
