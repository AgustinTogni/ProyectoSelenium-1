package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Set;

public class TestingIDLG {

    private String url = "https://compragamer.com/";
    WebDriver driver;

    @BeforeMethod
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "E:\\ProyectosSelinium\\ProyectoSelenium-1\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
    }

    @Test(priority = 1)
    public void RegisterWithValidData() throws InterruptedException {

        // Credentials
        String username = "Agustin";
        String password = "Togni Balassi";

        // Test
        WebElement btnLogIn = driver.findElement(By.className("mat-button-wrapper"));
        btnLogIn.click();

        WebElement btnCreateAccount = driver.findElement(By.className("mat-stroked-button"));
        btnCreateAccount.click();

        WebElement usernameInput = driver.findElement(By.id("mat-input-2"));
        WebElement passwordInput = driver.findElement(By.id("mat-input-3"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    @AfterMethod
    public void CloseSession(){
        driver.quit();
    }

}
