package com.revolut.validator;

import com.revolut.exception.UrlShortnerException;

import javax.xml.transform.URIResolver;
import java.util.Optional;

public class UserInputValidatorImpl {

    public Boolean validateSoeLength(Optional<String> soe){
        return soe.get().length() <= 20 ? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean validateUrl(Optional<String> url){
        if(url.isEmpty()) {
            throw new UrlShortnerException("Please supply the url that needs to be shortned");
        }
        return url.get().contains("http");
    }
}
