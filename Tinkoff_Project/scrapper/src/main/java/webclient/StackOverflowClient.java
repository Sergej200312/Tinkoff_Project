package webclient;


import reactor.core.publisher.Mono;

public interface StackOverflowClient {
    Mono<QuestionResponse> getQuestion(int questionId);
}
