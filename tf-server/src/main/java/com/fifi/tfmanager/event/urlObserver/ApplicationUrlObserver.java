package com.fifi.tfmanager.event.urlObserver;

import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


@Component
@Eager
public class ApplicationUrlObserver implements PropertyChangeListener {

    private static String appUrl;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.setAppUrl((String) evt.getNewValue());
    }

    public static String getAppUrl() {
        return appUrl;
    }

    private void setAppUrl(String appUrl) {
        ApplicationUrlObserver.appUrl = appUrl;
    }
}
