package com.vesska.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.vesska.config.Config;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private static Config config = ConfigFactory.create(Config.class);
    @SneakyThrows
    @Override
    @Nonnull

    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);


        mutableCapabilities.setCapability("browserstack.user", config.login());
        mutableCapabilities.setCapability("browserstack.key", config.password());


        mutableCapabilities.setCapability("app", config.appUrl());


        mutableCapabilities.setCapability("device", config.device());
        mutableCapabilities.setCapability("os_version",config.osVersion());


        mutableCapabilities.setCapability("project", config.projectName());
        mutableCapabilities.setCapability("build", config.buildName());
        mutableCapabilities.setCapability("name", config.testName());


        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
