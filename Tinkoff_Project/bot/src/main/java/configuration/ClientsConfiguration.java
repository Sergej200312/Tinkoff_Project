package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import telegram.ScrapperClient;

@Configuration
public class ClientsConfiguration {
    private final static String SCRAPPER_CLIENT_DEFAULT_URL = "http://localhost:8080";

    @Bean
    ScrapperClient scrapperClient(ApplicationConfig appConfig) {
        WebClient webClient = WebClient.builder()
                .baseUrl(appConfig.baseUrlScrapper().isBlank() ? SCRAPPER_CLIENT_DEFAULT_URL : appConfig.baseUrlScrapper())
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        return factory.createClient(ScrapperClient.class);
    }
}