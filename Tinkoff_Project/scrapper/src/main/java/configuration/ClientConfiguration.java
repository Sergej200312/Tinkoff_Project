package configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import webclient.*;
import webclient.GitHubClient;

@Configuration
public class ClientConfiguration {

    @Bean
    public GitHubClient gitHubClient() {
        return new GitHubClientImpl((WebClient) WebClient.builder());
    }

    @Bean
    public StackOverflowClient stackOverflowClient() {
        return new StackOverflowClientImpl((WebClient) WebClient.builder());
    }

}