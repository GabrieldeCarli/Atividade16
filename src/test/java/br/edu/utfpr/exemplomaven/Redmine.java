package br.edu.utfpr.exemplomaven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author renil
 */
public class Redmine {

    private static String CHROMEDRIVER_LOCATION = "C:\\Users\\gabri\\Documents\\Selenium\\chromedriver.exe";

    private static int scId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCATION);
    }

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();

        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void loginInvalido() {
        LoginPage login = new LoginPage(driver);
        login.clicarEntrar();
        login.inserirUsuario("gabriel").inserirSenha("roberto").loginInvalido();
        login.realizarLogin();
        assertEquals("Usuário ou senha inválido.", login.getError());
    }

    @Test
    public void loginValido() {
        LoginPage login = new LoginPage(driver);
        login.clicarEntrar();
        login.inserirUsuario("GabrieldeCarli").inserirSenha("asdffdsa").loginInvalido();
        MainPage mp = login.realizarLogin();
        assertEquals("Acessando como: GabrieldeCarli", mp.loggedas.getText());
    }

    @Test
    public void buscar() {
        LoginPage login = new LoginPage(driver);
        login.clicarEntrar();
        login.inserirUsuario("GabrieldeCarli").inserirSenha("asdffdsa").loginInvalido();
        MainPage mp = login.realizarLogin();
        mp.buscarDados("alguma coisa");
        assertEquals("Busca", mp.search_form.getText());
    }
}
