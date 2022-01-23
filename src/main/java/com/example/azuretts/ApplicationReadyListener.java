package com.example.azuretts;

import com.example.azuretts.exception.SynthesisException;
import com.example.azuretts.service.AzureTTSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyListener.class);

    @Autowired
    private AzureTTSService azureTTSService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        String text = "Hello, World!";
        try {
            azureTTSService.synthesizeAndSpeak(text);
            azureTTSService.synthesizeAndSaveToFile(text);
        } catch (SynthesisException e) {
            LOGGER.error(e.getMessage());
        }
    }
}