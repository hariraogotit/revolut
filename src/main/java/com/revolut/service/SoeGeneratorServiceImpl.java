package com.revolut.service;

import java.util.Optional;
import java.util.UUID;

public class SoeGeneratorServiceImpl {

    public Optional<String> generateSoe(){
        return Optional.of(UUID.randomUUID().toString().substring(0,4));
    }
}
