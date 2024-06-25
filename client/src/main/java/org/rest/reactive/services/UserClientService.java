package org.rest.reactive.services;

import lombok.RequiredArgsConstructor;
import org.rest.reactive.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class UserClientService {

    private final RestTemplate restTemplate;

    public List<User> fetchUsers(List<String> userIdList){
        Executor executor = Executors.newFixedThreadPool(10);
        var futureUsers= userIdList.stream().map(
                s -> CompletableFuture.supplyAsync(
                () -> getUserFromDownStream(s),executor)).toList();
        return futureUsers.stream().map(CompletableFuture :: join).toList();
    }

    private User getUserFromDownStream(String userId)  {
        try {
            return restTemplate.getForObject(new URI("http://localhost:8090/users/"+userId),User.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
