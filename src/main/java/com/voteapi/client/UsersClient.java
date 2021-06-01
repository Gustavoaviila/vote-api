package com.voteapi.client;


import com.voteapi.controller.Dto.StatusCpfDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "feignCpf", url = "https://user-info.herokuapp.com")
public interface UsersClient {

    @GetMapping("/users/{cpf}")
    ResponseEntity <StatusCpfDto> verifyCpf (@PathVariable String cpf);
}
