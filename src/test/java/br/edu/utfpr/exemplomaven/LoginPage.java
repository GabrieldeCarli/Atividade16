/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.exemplomaven;

import static org.openqa.selenium.By.name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Gabriel de Carli
 */
public class LoginPage extends BasePage{
    
    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("http://demo.redmine.org/");
    }
    
    @FindBy(className = "login")
    WebElement entrar;   //Entrar
    WebElement username; //Email
    WebElement password; //Senha
    @FindBy(name = "login")
    WebElement botaologin;
    WebElement flash_error;
    
    
    //Botao Entrar
    public void clicarEntrar(){
        entrar.click();  
    }
    //Botao Login
    
    public LoginPage inserirSenha(String senha){
        password.sendKeys(senha);
        return this;
    }
    public LoginPage inserirUsuario(String user){
        username.sendKeys(user);
        return this;
    }
    public MainPage realizarLogin(){
        botaologin.click();
        return new MainPage(driver);
    }
    public LoginPage loginInvalido(){
        return this;
    }
    public String getError(){
        return flash_error.getText();
    }
    
}
