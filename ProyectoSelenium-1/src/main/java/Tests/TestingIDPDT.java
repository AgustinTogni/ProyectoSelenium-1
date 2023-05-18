package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.time.Duration;

public class TestingIDPDT {

    private String url = "https://compragamer.com/?seccion=3";
    private String url2 = "https://compragamer.com/";
    WebDriver driver;
    Logger log;
    WebDriverWait wait;

    @BeforeMethod
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "E:\\ProyectosSelinium\\ProyectoSelenium-1\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        log = LogManager.getLogger(TestingIDLG.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void ToggleListModeGridModePDT001() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

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
    public void FeaturedFilterPDT002() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

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
    public void higherPriceFilterPDT003() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

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
    public void addToCartPDT004() throws InterruptedException {

        // Credentials
        String email = "";
        String password = "";

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        driver.manage().window().maximize();

        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.cssSelector("div.ng-tns-c103-4 input.mat-input-element")).sendKeys(email);

        driver.findElement(By.className("continue")).click();

        By passwordSelector = By.cssSelector("div.ng-tns-c103-6 input.mat-input-element");
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(passwordSelector));

        passwordInput.sendKeys(password);

        WebElement enterBtn = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/cgw-dialog-modal/div/cgw-login/div/div/div/button[1]/span"));
        Point location = enterBtn.getLocation();
        int positionX = location.getX();
        int positionY = location.getY();
        Actions actions = new Actions(driver);
        actions.moveByOffset(positionX, positionY).click().build().perform();

        driver.findElement(By.id("productos")).click();

    }

    @Test(enabled = false) // Unfinished.
    public void addInfiniteProductsToCartPDT005() throws InterruptedException {}

    @Test(enabled = false) // Unfinished.
    public void LettersInTheMinimumPriceFilterPDT006() throws InterruptedException {

        List<WebElement> listElements = driver.findElements(By.cssSelector(".mat-expansion-panel-header-title"));
        for (WebElement notebooksOption : listElements) {
            if (notebooksOption.getText().equals("Equipos y Notebooks")) {
                notebooksOption.click();
                break;
            }
        }
    }

    @AfterMethod
    public void CloseSession(){
        log.info("#######");
        log.info("[ Driver Status ] clean and close controller instance");
        log.info("#######");
        driver.quit();
    }
}
