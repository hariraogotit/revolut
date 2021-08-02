package com.revolut.handler;

import com.revolut.service.SoeGeneratorServiceImpl;
import com.revolut.service.UrlShortnerServiceImpl;
import com.revolut.validator.UserInputValidatorImpl;

import java.util.Optional;

public class UrlHandlerImpl {

    private UrlShortnerServiceImpl urlShortnerService;
    private UserInputValidatorImpl userInputValidator;
    private SoeGeneratorServiceImpl soeGeneratorService;

    public UrlHandlerImpl(UrlShortnerServiceImpl urlShortnerService,
                          UserInputValidatorImpl userInputValidator,
                          SoeGeneratorServiceImpl soeGeneratorService) {
        this.urlShortnerService = urlShortnerService;
        this.userInputValidator = userInputValidator;
        this.soeGeneratorService = soeGeneratorService;
    }

    public Optional<String> shorten(Optional<String> url, Optional<String> soe){
        Optional<String> shortnedUrl = Optional.empty();
        if(!soe.isPresent()){
            soe = soeGeneratorService.generateSoe();
        }
        if(userInputValidator.validateSoeLength(soe) && userInputValidator.validateUrl(url)){
            shortnedUrl = urlShortnerService.applyShortner(url, soe);
        }
        return shortnedUrl;
    }
}
