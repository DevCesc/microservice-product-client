package com.bootcamp.controller;

import com.bootcamp.model.ProductClient;
import com.bootcamp.service.IProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class ProductClientController {

    @Autowired
    private IProductClientService service;


    @PostMapping
    public Mono<ResponseEntity<ProductClient>> save(@RequestBody ProductClient productClient, final ServerHttpRequest req){
        return service.save(productClient)
                .map(e -> ResponseEntity
                        .created(URI.create(req.getURI().toString().concat("/").concat(e.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                );
    }

    @GetMapping("/{idclient}")
    public Flux<ResponseEntity<ProductClient>> findAllByIdClient (@PathVariable("idclient") String idClient){
        return service.findAllByIdClient(idClient)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



}
