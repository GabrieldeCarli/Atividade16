/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.exemplomaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Gabriel de Carli
 */
public class MainPage extends BasePage{
    
    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    WebElement loggedas;
    WebElement q;
    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div[2]/h2")
    WebElement search_form;
    
      
    public String emailLogado(){
            return loggedas.getText();
            
    }
    
    public void buscarDados(String dados){
        q.sendKeys(dados);
        q.submit();
    }
     public String formBusca(){
        return search_form.getText();
    }
}
