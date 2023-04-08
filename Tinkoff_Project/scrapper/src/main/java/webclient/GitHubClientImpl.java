package webclient;



import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class GitHubClientImpl implements GitHubClient {
    private WebClient webClient;

    public void GithubClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public GitHubClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<RepositoryResponse> getRepository(String owner, String repoName) {
        return webClient.get()
                .uri("/repos/{owner}/{repo}", owner, repoName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(RepositoryResponse.class);
    }
}
