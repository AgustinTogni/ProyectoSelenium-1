package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.time.Duration;

public class TestingIDPDT {

    private String url = "https://compragamer.com/?seccion=3";
    WebDriver driver;
    Logger log;
    WebDriverWait wait;

    @BeforeMethod
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "E:\\ProyectosSelinium\\ProyectoSelenium-1\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        log = LogManager.getLogger(TestingIDLG.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);
    }

    @Test(priority = 1)
    public void ToggleListModeGridModePDT001() throws InterruptedException {

        driver.manage().window().maximize();

        driver.findElement(By.className("boton-inactivo")).click();

        WebElement grid = driver.findElement(By.className("prueba_grid"));
        if (grid.isDisplayed()) {
            System.out.println("The Grid Mode is visible");
        } else {
            Assert.fail("The Grid Mode is not visible");
        }
    }

    @Test(priority = 2)
    public void FeaturedFilter() throws InterruptedException {

        driver.findElement(By.className("mat-select-arrow-wrapper")).click();

        List<WebElement> options = driver.findElements(By.className("mat-option-text"));

        for (WebElement featuredOption : options) {
            if (featuredOption.getText().equals("Destacados")) {
                featuredOption.click();
                break;
            }
        }
    }

    @Test(priority = 3)
    public void higherPriceFilter() throws InterruptedException {

        driver.findElement(By.className("mat-select-arrow-wrapper")).click();

        List<WebElement> options = driver.findElements(By.className("mat-option-text"));

        for (WebElement featuredOption : options) {
            if (featuredOption.getText().equals("Mayor precio")) {
                featuredOption.click();
                break;
            }
        }
    }

    @Test(enabled = false) // Unfinished.
    public void addToCar() throws InterruptedException {

    }

    @AfterMethod
    public void CloseSession(){
        log.info("#######");
        log.info("[ Driver Status ] clean and close controller instance");
        log.info("#######");
        driver.quit();
    }
}
