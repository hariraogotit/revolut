package com.revolut.service;

import java.util.Optional;

import static com.revolut.util.UrlShortnerConstants.SHORT_URL;

public class UrlShortnerServiceImpl {

    public Optional<String> applyShortner(Optional<String> url, Optional<String> soe){
        return Optional.of(SHORT_URL.concat(soe.get()));
    }
}
