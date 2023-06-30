package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageAccounts extends BasePage {
    By usuario = By.name("username");
    By contrasena = By.name("password");
    By buttonLogIn = By.xpath("//*[@id=\'loginPanel\']/form/div[3]/input");
    By resultadologIn = By.xpath("//*[@id=\'rightPanel\']/div/div/h1");

    By nuevaCuenta = By.xpath("//*[@id=\'leftPanel\']/ul/li[1]/a");
    By tipo = By.xpath("//*[@id=\'type\']/option[2]");
    By form = By.xpath("//*[@id=\'rightPanel\']/div/div/form");
    By abirCuenta = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div/input");
    By resultadoCta = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/p[1]");

    By resumenCuenta = By.xpath("//*[@id=\'leftPanel\']/ul/li[2]/a");
    By resultadoResumen = By.xpath("//*[@id=\'accountTable\']/tfoot/tr/td");


    By nuevaTransferencia = By.xpath("//*[@id=\'leftPanel\']/ul/li[3]/a");
    By titulo = By.xpath("//*[@id=\'rightPanel\']/div/div/h1");
    By monto = By.name("input");
    By cuentaOrigen = By.xpath("//*[@id=\'fromAccountId\']/option[1]");
    By cuentaDestino = By.xpath("//*[@id=\'toAccountId\']/option[1]");
    By transferir = By.xpath("//*[@id=\'rightPanel\']/div/div/form/div[2]/input");
    By resultadoTransferencia = By.xpath("//*[@id=\'rightPanel\']/div/div/h1");

    By cuentaNro = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[1]/a");
    By go = By.className("button");
    By periodo = By.xpath("//*[@id='month']//option[@value='All']");
    By tipoCta = By.xpath("//*[@id=\'transactionType\']//option[@value='All']");


    public PageAccounts(WebDriver driver) {
        super();
    }

    public void logIn(){
        teclear("dolores",usuario);
        teclear("123456",contrasena);
        oprimir(buttonLogIn);
        esperaExplictaText(10,resultadologIn,"Accounts Overview");
    }
    public void crearCuenta(){
        oprimir(nuevaCuenta);
        esperaExplictabutton(10,nuevaCuenta);
        oprimir(tipo);
        oprimir(form);
        oprimir(abirCuenta);
        esperaExplictaText(10,resultadoCta,"Congratulations, your account is now open.");
        comparar(resultadoCta,"Congratulations, your account is now open.");
    }
    public void resumenCuenta(){
        oprimir(resumenCuenta);
        esperaExplictaText(10, resultadoResumen,"Balance includes deposits that may be subject to holds");
        comparar(resultadoResumen,"Balance includes deposits that may be subject to holds");
    }
    public void transferirFondos(){
        oprimir(nuevaTransferencia);
        esperaExplictaText(10,titulo,"Transfer Funds");
        teclear("10",monto);
        oprimir(cuentaOrigen);
        oprimir(cuentaDestino);
        oprimir(transferir);
        esperaExplictaText(10, resultadoTransferencia,"Transfer Complete!");
        comparar(resultadoTransferencia,"Transfer Complete!");
    }
    public void actividadCuenta(){
        oprimir(resumenCuenta);
        esperaExplictaText(10, resultadoResumen,"Balance includes deposits that may be subject to holds");
        comparar(resultadoResumen,"Balance includes deposits that may be subject to holds");
        esperaExplictabutton(10,cuentaNro);
        oprimir(cuentaNro);
        comparar(titulo,"Account Details");
        oprimir(periodo);
        oprimir(tipoCta);
        oprimir(go);
    }
}
