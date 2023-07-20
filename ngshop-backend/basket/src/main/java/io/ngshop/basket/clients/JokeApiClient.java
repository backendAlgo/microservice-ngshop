package io.ngshop.basket.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "jokeApiClient", url = "https://official-joke-api.appspot.com/")
public interface JokeApiClient {
    @GetMapping("/random_joke")
    Joke getRandomeJoke();
}
