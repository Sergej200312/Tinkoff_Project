package webclient;


import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class StackOverflowClientImpl implements StackOverflowClient {
    private WebClient webClient;


    public void StackOverflowClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public StackOverflowClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<QuestionResponse> getQuestion(int questionId) {
        return webClient.get()
                .uri("/2.3/questions/{id}", questionId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(QuestionResponse.class);
    }
}
