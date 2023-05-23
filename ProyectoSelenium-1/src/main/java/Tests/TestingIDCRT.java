package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.time.Duration;

public class TestingIDCRT {

    private String url = "https://compragamer.com/?tipo_pago=3&listado_prod=&seccion=11";
    private String url2 = "https://compragamer.com/?seccion=3";
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
    public void ButtonSEGUIRCOMPRANDOCRT001() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/cgw-patch/div/div/cgw-shopping-cart/div/div/div[2]/div/button/span/span")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement imgOutstanding = driver.findElement(By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/cgw-banners-subcategory/div/div[2]/picture/img"));
        if (imgOutstanding.isDisplayed()) {
            System.out.println("The outstanding image is visible.");
        } else {
            Assert.fail("The outstanding image is not visible.");
        }
    }

    @Test(priority = 2)
    public void AddProductToCartCRT002() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        btnAddToCart.click();

        WebElement Cart = driver.findElement(By.className("mat-icon-button"));
        if (Cart.isDisplayed()) {
            System.out.println("The product was added to cart.");
        } else {
            Assert.fail("The product wasn't added to cart.");
        }

    }

    @Test(priority = 3)
    public void FillInZipCodeCRT003() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        btnAddToCart.click();

        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        cart.click();

        By zipCodeSelector = By.id("mat-input-2");
        WebElement zipCodeInput = wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeSelector));

        zipCodeInput.sendKeys("1625");

        String zipCodeInputCheck = zipCodeInput.getAttribute("value");
        if (!zipCodeInputCheck.isEmpty()) {
            System.out.println("The field is complete.");
        } else {
            Assert.fail("The field is empty.");
        }
    }

    @Test(priority = 4)
    public void RemoveProductFromCartCRT004() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        btnAddToCart.click();

        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        cart.click();

        driver.findElement(By.className("icon-trash")).click();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/cgw-patch/div/div/cgw-shopping-cart/div/div/div[2]/div/h3"));
        if (alert.isDisplayed()) {
            System.out.println("The cart is empty.");
        } else {
            Assert.fail("The cart is not empty.");
        }

    }

    @Test(priority = 5)
    public void InvalidDiscountCodeCRT005() throws InterruptedException {

        // Credentials
        String discountCode = "InvalidCode123";

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        btnAddToCart.click();

        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        cart.click();

        driver.findElement(By.id("mat-input-1")).sendKeys(discountCode);

        driver.findElement(By.xpath("//*[@id=\"commands\"]/button")).click();

        By alertSelector = By.className("ng-star-inserted");
        WebElement alert = wait.until(ExpectedConditions.presenceOfElementLocated(alertSelector));

        if (alert.isDisplayed()) {
            System.out.println("The alert is visible.");
        } else {
            Assert.fail("The alert is not visible.");
        }
    }

    @Test(priority = 6)
    public void WordsInZipCodeCRT006() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        btnAddToCart.click();

        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        cart.click();

        By zipCodeSelector = By.id("mat-input-2");
        WebElement zipCodeInput = wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeSelector));

        zipCodeInput.sendKeys("sdasdasda");

        String zipCodeInputCheck = zipCodeInput.getAttribute("value");
        if (!zipCodeInputCheck.isEmpty()) {
            Assert.fail("The field is complete.");
        } else {
            System.out.println("The field is empty.");
        }
    }

    @Test(priority = 7)
    public void SpecialCharactersInZipCodeCRT007() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        btnAddToCart.click();

        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        cart.click();

        By zipCodeSelector = By.id("mat-input-2");
        WebElement zipCodeInput = wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeSelector));

        zipCodeInput.sendKeys("%$@$@#$@%");

        String zipCodeInputCheck = zipCodeInput.getAttribute("value");
        if (!zipCodeInputCheck.isEmpty()) {
            Assert.fail("The field is complete.");
        } else {
            System.out.println("The field is empty.");
        }
    }

    @Test(priority = 8)
    public void AddInfiniteProductsCRT008() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        btnAddToCart.click();

        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        cart.click();

        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"commands\"]/div/span[3]/button"));

        while (addToCart.isEnabled()) {
            addToCart.click();
        }

        WebElement alertLimit = driver.findElement(By.className("warning"));
        if (alertLimit.isDisplayed()) {
            System.out.println("The alert limit is visible.");
        } else {
            Assert.fail("The alert limit is not visible");
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
