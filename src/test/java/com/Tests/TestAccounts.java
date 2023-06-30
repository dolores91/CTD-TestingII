package com.Tests;
import com.Pages.PageAccounts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestAccounts {
    static WebDriver driver;
    static PageAccounts pageAccounts;
    static ExtentSparkReporter spark;
    static ExtentReports extent;

    @BeforeAll
    public static void setUpAll() {
        spark = new ExtentSparkReporter("target/accounts.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        pageAccounts = new PageAccounts(driver);
        driver = pageAccounts.chromeDriverConnection();
        pageAccounts.link("https://parabank.parasoft.com/parabank/index.htm");
        pageAccounts.logIn();
    }

    @AfterAll
    public static void tearDownAll() {
        extent.flush();
        driver.quit();
    }
    @Test
    @Tag("regresion")
    public void testNuevaCuenta() {
        ExtentTest test = extent.createTest("Creación de una nueva cuenta");
        test.log(Status.INFO, "Inicia el test");
        pageAccounts.crearCuenta();
        test.log(Status.PASS, "Cuenta creada con éxito");
    }

    @Test
    @Tag("regresion")
    public void testResumenCuentas() {
        ExtentTest test = extent.createTest("Ver información sobre cuentas");
        test.log(Status.INFO, "Inicia el test");
        pageAccounts.resumenCuenta();
        test.log(Status.PASS, "Información mostrada correctamente");
    }
    @Test
    @Tag("regresion")
    public void testTransferencias() {
        ExtentTest test = extent.createTest("Realizar transferencia");
        test.log(Status.INFO, "Inicia el test");
        pageAccounts.transferirFondos();
        test.log(Status.PASS, "Transferencia realizada con éxito");
    }
    @Test
    @Tag("regresion")
    public void testActividadCuenta() {
        ExtentTest test = extent.createTest("Mostrar actividad de una cuenta");
        test.log(Status.INFO, "Inicia el test");
        pageAccounts.actividadCuenta();
        test.log(Status.PASS, "Información mostrada correctamente");
    }
}