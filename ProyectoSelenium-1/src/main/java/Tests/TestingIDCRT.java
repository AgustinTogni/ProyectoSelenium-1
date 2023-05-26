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

import java.time.Duration;

public class TestingIDCRT {

    private String url = "https://compragamer.com/?tipo_pago=3&listado_prod=&seccion=11";
    private String url2 = "https://compragamer.com/?seccion=3";
    WebDriver driver;
    Logger log;
    WebDriverWait wait;

    @BeforeMethod
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "E:\\ProyectosSelenium\\ProyectoSelenium-1\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        log = LogManager.getLogger(TestingIDCRT.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void ButtonKeepBuyingCRT001() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

        // --- Test ---

        // The "SEGUIR COMPRANDO" button is clicked.
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/cgw-patch/div/div/cgw-shopping-cart/div/div/div[2]/div/button/span/span")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // It is verified that "PRODUCTO" section is visible.
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

        // --- Test ---

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // The "AGREGAR AL CARRITO" button is clicked.
        btnAddToCart.click();

        // It is verified that the product was added to cart.
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

        // --- Test ---

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // The "AGREGAR AL CARRITO" button is clicked.
        btnAddToCart.click();

        // Wait for cart to appear.
        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        // The cart is clicked.
        cart.click();

        // Wait for field to appear.
        By zipCodeSelector = By.id("mat-input-2");
        WebElement zipCodeInput = wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeSelector));

        // The field is complete with zip code.
        zipCodeInput.sendKeys("1625");

        // It is verified that the field is complete.
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

        // --- Test ----

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // The "AGREGAR AL CARRITO" button is clicked.
        btnAddToCart.click();

        // Wait for cart to appear.
        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        // The cart is clicked.
        cart.click();

        // The trash button is clicked.
        driver.findElement(By.className("icon-trash")).click();

        // It is verified that the cart is empty.
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/cgw-patch/div/div/cgw-shopping-cart/div/div/div[2]/div/h3"));
        if (alert.isDisplayed()) {
            System.out.println("The cart is empty.");
        } else {
            Assert.fail("The cart is not empty.");
        }

    }

    @Test(priority = 5)
    public void InvalidDiscountCodeCRT005() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        // Credentials
        String discountCode = "InvalidCode123";

        // --- Test ---

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // The "AGREGAR AL CARRITO" button is clicked.
        btnAddToCart.click();

        // Wait for cart to appear.
        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        // The cart is clicked.
        cart.click();

        // The field is complete with discount code.
        driver.findElement(By.id("mat-input-1")).sendKeys(discountCode);

        // The "APLICAR" button is clicked.
        driver.findElement(By.xpath("//*[@id=\"commands\"]/button")).click();

        // Wait for alert to appear.
        By alertSelector = By.className("ng-star-inserted");
        WebElement alert = wait.until(ExpectedConditions.presenceOfElementLocated(alertSelector));

        // It is verified that the alert is visible.
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

        // --- Test ---

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // The "AGREGAR AL CARRITO" button is clicked.
        btnAddToCart.click();

        // Wait for cart to appear.
        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        // The cart is clicked.
        cart.click();

        // Wait for field to appear.
        By zipCodeSelector = By.id("mat-input-2");
        WebElement zipCodeInput = wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeSelector));

        // The field is completed with invalid zip code.
        zipCodeInput.sendKeys("sdasdasda");

        // It is verified that the field is complete.
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

        // --- Test ---

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // The "AGREGAR AL CARRITO" button is clicked.
        btnAddToCart.click();

        // Wait for cart to appear.
        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        // The cart is clicked.
        cart.click();

        // Wait for field to appear.
        By zipCodeSelector = By.id("mat-input-2");
        WebElement zipCodeInput = wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeSelector));

        // The field is complete with invalid zip code.
        zipCodeInput.sendKeys("%$@$@#$@%");

        // It is verified that the field is complete.
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

        // --- Test ---

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // The "AGREGAR AL CARRITO" button is clicked.
        btnAddToCart.click();

        // Wait for cart to appear.
        By cartSelector = By.className("mat-icon-button");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(cartSelector));

        // The cart is clicked.
        cart.click();

        // Infinite clicks on the "+" button.
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"commands\"]/div/span[3]/button"));

        while (addToCart.isEnabled()) {
            addToCart.click();
        }

        // It is verified that the limit alert is visible.
        WebElement alertLimit = driver.findElement(By.className("warning"));
        if (alertLimit.isDisplayed()) {
            System.out.println("The limit alert is visible.");
        } else {
            Assert.fail("The limit alert is not visible");
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
