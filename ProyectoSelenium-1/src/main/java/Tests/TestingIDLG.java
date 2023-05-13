package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class TestingIDLG {

    private String url = "https://compragamer.com/";
    WebDriver driver;
    Logger log;

    @BeforeMethod
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "E:\\ProyectosSelinium\\ProyectoSelenium-1\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        log = LogManager.getLogger(TestingIDLG.class);

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);
    }

    // @Test(priority = 1) unfinished.
    public void LoginWithValidDataLG001() throws InterruptedException {

        // Credentials
        String email = "";
        String password = "";

        // Test
        WebElement btnLogIn = driver.findElement(By.className("mat-button-wrapper"));
        btnLogIn.click();

        WebElement emailInput = driver.findElement(By.cssSelector("div.ng-star-inserted input"));
        emailInput.sendKeys("");

        WebElement btnContinue = driver.findElement(By.className("mat-raised-button"));
        btnContinue.click();

        driver.findElement(By.className("mat-form-field-autofill-control")).sendKeys(password);

        driver.findElement(By.className("mat-raised-button")).click();

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
        if(usernameInput.getAttribute("value").equals("Agustin")) {
            System.out.println("The entered username is present in the text field.");
        } else {
            System.out.println("The entered username is not present in the text field.");
        }

        WebElement lastnameInput = driver.findElement(By.id("mat-input-3"));
        lastnameInput.sendKeys(lastname);
        if(lastnameInput.getAttribute("value").equals("Togni Balassi")) {
            System.out.println("The entered lastname is present in the text field.");
        } else {
            System.out.println("The entered lastname is not present in the text field.");
        }
    }

    @Test(priority = 2)
    public void RegisterWithValidDataLG003() throws InterruptedException {

        // Credentials
        String phone = "78263242";

        //Test
        driver.findElement(By.className("mat-button-wrapper")).click();

        driver.findElement(By.className("mat-stroked-button")).click();

        WebElement phoneInput = driver.findElement(By.id("mat-input-6"));
        phoneInput.sendKeys(phone);
        if(phoneInput.getAttribute("value").equals("78263242")) {
            System.out.println("The entered phone is present in the text field.");
        } else {
            System.out.println("The entered phone is not present in the text field.");
        }
    }

    @Test(priority = 3)
    public void CorrectRedirectionOfAlreadyHaveAnAccountLG004() throws InterruptedException {

        //Test
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

    @AfterMethod
    public void CloseSession(){
        log.info("#######");
        log.info("[ Driver Status ] clean and close controller instance");
        log.info("#######");
        driver.quit();
    }

}
