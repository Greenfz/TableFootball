package com.fifi.tfmanager.event.urlObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class UrlReceiver {

    private TomcatServletWebServerFactory tomcatServletWebServerFactory;


     String buildApplicationURL() {
        try{
            StringBuilder stringBuilder = new StringBuilder("http://");
            stringBuilder.append(getHostAddress());
            stringBuilder.append(":");
            stringBuilder.append(getPort());
            return stringBuilder.toString();
        } catch (UnknownHostException ex){
            ex.printStackTrace();
            return "";
        }
    }

    private int getPort() {
        return tomcatServletWebServerFactory.getPort();
    }

    private String getHostAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    @Autowired
    public UrlReceiver(TomcatServletWebServerFactory tomcatServletWebServerFactory) {
        this.tomcatServletWebServerFactory = tomcatServletWebServerFactory;
    }

}
