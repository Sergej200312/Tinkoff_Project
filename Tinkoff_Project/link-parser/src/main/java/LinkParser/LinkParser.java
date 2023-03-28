package LinkParser;

public interface LinkParser {
    String parse(String url);
    void setNextParser(LinkParser parser);
}
