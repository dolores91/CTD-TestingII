package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageIndex extends BasePage {

    By buttonRegister = By.xpath("//*[@id=\'loginPanel\']/p[2]/a");
    By nombre = By.name("customer.firstName");
    By apellido = By.name("customer.lastName");
    By direccion = By.name("customer.address.street");
    By ciudad = By.name("customer.address.city");
    By estado = By.name("customer.address.state");
    By codPostal = By.name("customer.address.zipCode");
    By telefono = By.name("customer.phoneNumber");
    By SSN = By.name("customer.ssn");
    By usuario = By.name("customer.username");
    By contrasena = By.name("customer.password");
    By contrasena2 = By.name("repeatedPassword");
    By buttonResgistrarse = By.xpath("//*[@id=\'customerForm\']/table/tbody/tr[13]/td[2]/input");
    By resultado = By.xpath("//*[@id=\'rightPanel\']/p");



    public PageIndex(WebDriver driver) {
        super();
    }

    public void register (){
        esperaExplictabutton(10,buttonRegister);
        oprimir(buttonRegister);
        teclear("dolo",nombre);
        teclear("aleman",apellido);
        teclear("zavalla", direccion);
        teclear("Santa Fe", ciudad);
        teclear("Santa Fe", estado);
        teclear("3000", codPostal);
        teclear("155087277",telefono);
        teclear("12345", SSN);
        teclear("dolores",usuario);
        teclear("123456",contrasena);
        teclear("123456",contrasena2);
        oprimir(buttonResgistrarse);
        esperaExplictaText(10,resultado,"Your account was created successfully. You are now logged in.");
        obtenerTexto(resultado);
        comparar(resultado,"Your account was created successfully. You are now logged in.");
    }

}
