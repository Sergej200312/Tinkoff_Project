package LinkParser;

public interface LinkHandler {
        void setNextHandler(LinkHandler nextHandler);
        String handleLink(String link);
}