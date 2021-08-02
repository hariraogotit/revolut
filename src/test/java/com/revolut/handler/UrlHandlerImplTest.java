package com.revolut.handler;

import com.revolut.service.SoeGeneratorServiceImpl;
import com.revolut.service.UrlShortnerServiceImpl;
import com.revolut.validator.UserInputValidatorImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.revolut.util.UrlShortnerConstants.MY_NEW_WS;
import static com.revolut.util.UrlShortnerConstants.SHORT_URL;
import static org.junit.jupiter.api.Assertions.*;

class UrlHandlerImplTest {

    private static UrlHandlerImpl urlHandler;

    @BeforeAll
    static void Initialize(){
        urlHandler = new UrlHandlerImpl(new UrlShortnerServiceImpl(),
                                        new UserInputValidatorImpl(),
                                        new SoeGeneratorServiceImpl());
    }

    @Test
    public void testShorten_WithUrlAndSoe_ShouldGiveShortnedUrl(){
        Optional<String> url = Optional.of("http://looooong.com/somepath");
        Optional<String> soe = Optional.of(MY_NEW_WS);
        Optional<String> expectedOutput = Optional.of(SHORT_URL.concat(MY_NEW_WS));
        Optional<String> actualOutput = urlHandler.shorten(url, soe);
        assertTrue(expectedOutput.get().equals(actualOutput.get()));
    }

    @Test
    public void testShorten_WithUrlAndNoSoe_ShouldGiveShortnedUrlWithRandomFourDigitAlphaNumericChars(){
        Optional<String> url = Optional.of("http://looooong.com/somepath");
        Optional<String> expectedOutput = Optional.of(SHORT_URL);
        Optional<String> actualOutput = urlHandler.shorten(url, Optional.empty());
        System.out.println(urlHandler.shorten(url, Optional.empty()));
    }



}