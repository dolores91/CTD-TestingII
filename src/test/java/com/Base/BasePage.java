package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {
    protected static WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        return driver;
    }

    public void teclear(String imputText,By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(imputText);
    }
    public static void oprimir (By locator) {
        driver.findElement(locator).click();
    }
    public void link (String url) {
        driver.get(url);
    }
    public void obtenerTexto (By locator) {
        String res = driver.findElement(locator).getText();
        System.out.println("Texto : " + res );
    }
    public void comparar (By locator, String texto) {
        String res = driver.findElement(locator).getText();
        assertTrue(res.contains(texto));
    }
    public void esperaExplictaText (int time, By locator, String texto){
        new WebDriverWait(driver, Duration.ofSeconds(time)).
                until(ExpectedConditions.textToBePresentInElementLocated(locator,texto));
    }
    public void esperaExplictabutton (int time, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(locator));
    }
}
