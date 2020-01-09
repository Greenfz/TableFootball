package com.fifi.tfmanager.event.urlObserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UrlReceiverTest {


    @Autowired
    UrlReceiver urlReceiver;

    @Test
    void should_build_valid_url() {
        String url = urlReceiver.buildApplicationURL();
        int firstColon = url.indexOf(":");
        int lastColon = url.lastIndexOf(':');

        String port = url.substring(lastColon + 1);
        String adress = url.substring(firstColon, lastColon);


        assertTrue(adress.contains("."));
        assertTrue(port.length() > 1);
        assertDoesNotThrow(() -> Integer.parseInt(port));
    }
}
