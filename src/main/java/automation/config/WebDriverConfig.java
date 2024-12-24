package automation.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    @Value("${browser}")
    private String browser;

    @Value("${timeout}")
    private int timeout;

    @Bean
    public WebDriver driver() {
        WebDriver driver;
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setAcceptInsecureCerts(true);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setAcceptInsecureCerts(true);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    throw new IllegalStateException("Unknown browser type: " + browser);
            }
            driver.manage().window().maximize();

        } catch (Exception e) {
            System.err.println("Error initializing WebDriver: " + e.getMessage());
            throw new IllegalStateException("WebDriver initialization failed", e);
        }

        return driver;
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }


}




