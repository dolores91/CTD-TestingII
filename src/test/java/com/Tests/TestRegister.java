package com.Tests;

import com.Pages.PageIndex;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import extentReport.ExtentFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestRegister {
    WebDriver driver;
    PageIndex pageIndex;
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Register.html");
    static ExtentReports extent;
    ExtentTest test;

    @BeforeEach
    public void setUp (){
        pageIndex = new PageIndex(driver);
        driver = pageIndex.chromeDriverConnection();
        pageIndex.link("https://parabank.parasoft.com/parabank/index.htm");
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);
    }

    @Test
    @Tag("smoke")
    public void testRegistro (){
        test = extent.createTest("Registro positivo");
        test.log(Status.INFO, "inicia el test");
        pageIndex.register();
        test.log(Status.PASS,"Registro exitoso");
    }
    @AfterEach
    public void tearDown (){
        extent.flush();
        driver.quit();
    }
}
