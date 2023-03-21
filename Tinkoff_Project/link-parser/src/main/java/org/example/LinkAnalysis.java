package org.example;
import GitHub.GitHubParser;
import LinkParser.LinkParser;
import OtherLink.OtherLinkParser;
import StackOverflow.StackOverflowParser;

/**
 * Hello world!
 *
 */
public class LinkAnalysis
{
    private LinkParser chain;

    public LinkAnalysis() {
        chain = new GitHubParser();
        LinkParser stackOverflowParser = new StackOverflowParser();
        LinkParser unknownParser = new OtherLinkParser();
        chain.setNextParser(stackOverflowParser);
        stackOverflowParser.setNextParser(unknownParser);
    }

    public String parse(String url) {
        return chain.parse(url);
    }

    public static void main(String[] args) {
        LinkAnalysis linkParserChain = new LinkAnalysis();
        String url = "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c";
        String parsedUrl = linkParserChain.parse(url);
        System.out.println(parsedUrl);
    }
}
