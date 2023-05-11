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
    public void loginWithValidData() throws InterruptedException {

        // Credentials

        // Locators

        //Test

    }

    @AfterMethod
    public void CloseSession(){
        driver.quit();
    }

}
