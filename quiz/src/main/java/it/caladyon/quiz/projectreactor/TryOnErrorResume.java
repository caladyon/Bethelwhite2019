package it.caladyon.quiz.projectreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TryOnErrorResume {

	public static void main(String[] args) {
		Flux.just("a", "b", "c")
				.flatMap(x -> Mono.just(x + "1"))
				.flatMap(x -> {
					if (x.startsWith("b")) {
						return Mono.error(new IllegalStateException());
					} else {
						return Mono.just(x + "2");
					}
				})
				.flatMap(x -> Mono.just(x + "3"))
				.onErrorResume(t -> Mono.just("resumed"))
				.subscribe(x -> System.out.println(">>> " + x));
	}
}
