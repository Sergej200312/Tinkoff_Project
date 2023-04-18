package webclient;


import reactor.core.publisher.Mono;

public interface GitHubClient {
        Mono<RepositoryResponse> getRepository(String owner, String repoName);
}
