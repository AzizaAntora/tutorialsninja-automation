package com.tutorialsninja.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {
	public static WebDriver initializeDriver() {
        String browser = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        String os = System.getProperty("os.name").toLowerCase();

        // Set OS-specific configurations
        if (os.contains("win")) {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.http.factory", "apache");
        }
        
        switch (browser.toLowerCase()) {
            case "chrome":
                // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                if (headless) options.addArguments("--headless=new");
                // OS-specific arguments
                if (os.contains("linux")) {
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }

                return new ChromeDriver(options);
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

}
