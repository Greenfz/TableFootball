package com.fifi.tfmanager.urlObserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Component
@Scope("singleton")
public class ApplicationUrlObservable implements ServletContextListener {

    private String appUrl;
    private UrlReceiver urlReceiver;
    private PropertyChangeSupport UrlChangeSupport;
    private PropertyChangeListener observers[] = {new ApplicationUrlObserver()};

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initObservers();
        setAppUrl(urlReceiver.buildApplicationURL());
    }

    private void initObservers() {
        UrlChangeSupport = new PropertyChangeSupport(this);
//        UrlChangeSupport.addPropertyChangeListener(new ApplicationUrlObserver());
        for(PropertyChangeListener observer: observers){
            UrlChangeSupport.addPropertyChangeListener(observer);
        }
    }

    @Autowired
    public ApplicationUrlObservable(UrlReceiver urlReceiver) {
        this.urlReceiver = urlReceiver;
    }

    private void setAppUrl(String appUrl) {
        UrlChangeSupport.firePropertyChange("appUrl", this.appUrl, appUrl);
        this.appUrl = appUrl;
    }
}
