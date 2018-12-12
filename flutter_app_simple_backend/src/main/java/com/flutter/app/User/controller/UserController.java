package com.flutter.app.User.controller;

import com.flutter.app.User.model.User;
import com.flutter.app.User.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Controller()
@RequestMapping("/user")
public class UserController
{
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Mono<ServerResponse> getUser(@PathVariable String id){
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<User> userMono =   userRepository.findById(id);
        return userMono.flatMap(
                user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(user))).switchIfEmpty(notFound);

    }
}
