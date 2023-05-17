package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.time.Duration;

public class TestingIDLG {

    private String url = "https://compragamer.com/";
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

    //@Test(priority = 0) unfinished.
    public void LoginWithValidDataLG001() throws InterruptedException {

        // Credentials
        String email = "";
        String password = "";

        // Test
        driver.findElement(By.className("mat-focus-indicator")).click();

        driver.findElement(By.cssSelector("div.ng-tns-c103-4 input.mat-input-element")).sendKeys(email);;

        driver.findElement(By.className("continue")).click();

        By passwordSelector = By.cssSelector("div.ng-tns-c103-6 input.mat-input-element");
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(passwordSelector));

        passwordInput.sendKeys(password);
    }

    @Test(priority = 1)
    public void RegisterWithValidDataLG002() throws InterruptedException {

        // Credentials
        String username = "Agustin";
        String lastname = "Togni Balassi";

        // Test
        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.className("mat-stroked-button")).click();

        WebElement usernameInput = driver.findElement(By.id("mat-input-2"));
        usernameInput.sendKeys(username);

        String usernameCheck = usernameInput.getAttribute("value");
        if (!usernameCheck.isEmpty()) {
            System.out.println("The field is complete");
        } else {
            Assert.fail("The field is empty");
        }

        WebElement lastnameInput = driver.findElement(By.id("mat-input-3"));
        lastnameInput.sendKeys(lastname);

        String lastnameCheck = lastnameInput.getAttribute("value");
        if (!lastnameCheck.isEmpty()) {
            System.out.println("The field is complete");
        } else {
            Assert.fail("The field is empty");
        }
    }

    @Test(priority = 2)
    public void RegisterWithValidDataLG003() throws InterruptedException {

        // Test
        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.className("mat-stroked-button")).click();

        WebElement phoneInput = driver.findElement(By.id("mat-input-6"));
        phoneInput.sendKeys("82372233");

        String phoneCheck = phoneInput.getAttribute("value");
        if (!phoneCheck.isEmpty()) {
            System.out.println("The field is complete");
        } else {
            Assert.fail("The field is empty");
        }
    }

    @Test(priority = 3)
    public void CorrectRedirectionOfAlreadyHaveAnAccountLG004() throws InterruptedException {

        //  Test
        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.className("mat-stroked-button")).click();

        driver.findElement(By.cssSelector("a.vinculo")).click();

        WebElement RegisterPopup = driver.findElement(By.id("mat-dialog-0"));
        if (RegisterPopup.isDisplayed()) {
            System.out.println("The windows login is visible.");
        } else {
            System.out.println("The windows login is not visible.");
        }
    }

    @Test(priority = 4)
    public void RegisterWithNumbersInTheNameFieldLG005() throws InterruptedException {

        //  Test
        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.className("mat-stroked-button")).click();

        WebElement nameInput = driver.findElement(By.id("mat-input-2"));
        nameInput.sendKeys("1231312312");

        String fieldCheck = nameInput.getAttribute("value");
        if (!fieldCheck.isEmpty()) {
            Assert.fail("The field is complete");
        } else {
            System.out.println("The field is empty");
        }
    }

    @Test(priority = 5)
    public void RegisterWithSpecialCharactersInTheLastnameFieldLG006() throws InterruptedException {

        // Test
        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.className("mat-stroked-button")).click();

        WebElement lastnameInput = driver.findElement(By.id("mat-input-3"));
        lastnameInput.sendKeys("%$@$@#$@%");

        String fieldCheck = lastnameInput.getAttribute("value");
        if (!fieldCheck.isEmpty()) {
            Assert.fail("The field is complete");
        } else {
            System.out.println("The field is empty");
        }
    }

    //@Test(priority = 0) unfinished.
    public void RegisterWithoutEnteringDataLG007() throws InterruptedException {

        // Test
        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.className("mat-stroked-button")).click();

        WebElement registerBtn = driver.findElement(By.className("mat-button-base"));

        String colorBackground = registerBtn.getCssValue("background-color");

        String ExpectedColor = "rgb(224, 224, 224)";
        Assert.assertEquals("Background color does not match", ExpectedColor, colorBackground);
    }

    @Test(priority = 6)
    public void RegisterWithLettersInThePhoneFieldLG008() throws InterruptedException {

        // Test
        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.className("mat-stroked-button")).click();

        WebElement phoneInput = driver.findElement(By.id("mat-input-6"));
        phoneInput.sendKeys("LLDALDASA");

        String fieldCheck = phoneInput.getAttribute("value");
        if (!fieldCheck.isEmpty()) {
            Assert.fail("The field is complete");
        } else {
            System.out.println("The field is empty");
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
