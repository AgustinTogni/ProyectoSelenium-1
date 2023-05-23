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

        // Test
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

        // Test
        driver.findElement(By.className("mat-select-arrow-wrapper")).click();

        List<WebElement> options = driver.findElements(By.className("mat-option-text"));

        boolean actionPerformed = false;
        for (WebElement featuredOption : options) {
            if (featuredOption.getText().equals("Destacados")) {
                featuredOption.click();
                actionPerformed = true;
                break;
            }
        }

        if (actionPerformed) {
            System.out.println("The featured filter is enable.");
        } else {
            System.out.println("The featured filter is disable.");
        }
    }

    @Test(priority = 3)
    public void HigherPriceFilterPDT003() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

        // Test
        driver.findElement(By.className("mat-select-arrow-wrapper")).click();

        List<WebElement> options = driver.findElements(By.className("mat-option-text"));

        boolean actionPerformed = false;
        for (WebElement featuredOption : options) {
            if (featuredOption.getText().equals("Mayor precio")) {
                featuredOption.click();
                actionPerformed = true;
                break;
            }
        }

        if (actionPerformed) {
            System.out.println("The higher price filter is enable.");
        } else {
            System.out.println("The higher price filter is disable.");
        }
    }

    @Test(priority = 4)
    public void AddToCartPDT004() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        // Credentials
        String email = "Admin123@gmail.com";
        String password = "Admin";

        // Test
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

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        btnAddToCart.click();

        WebElement cart = driver.findElement(By.id("carrito-angular"));
        if (cart.isDisplayed()) {
            System.out.println("The product was add to cart");
        } else {
            Assert.fail("The product was not add to cart");
        }

    }

    @Test(priority = 5)
    public void AddInfiniteProductsToCartPDT005() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url2);

        // Credentials
        String email = "Admin123@gmail.com";
        String password = "Admin";

        // Test
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

        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        while (btnAddToCart.isEnabled()) {
            btnAddToCart.click();
        }

        if (!btnAddToCart.isEnabled()) {
            System.out.println("The button is disable.");
        } else {
            Assert.fail("The button is enabled.");
        }
    }

    @Test(priority = 6)
    public void LettersInTheMinimumPriceFilterPDT006() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

        // Test
        By hardwareAndNotebooksSelector = By.xpath("//*[@id=\"mat-expansion-panel-header-21\"]/span/mat-panel-title");
        WebElement hardwareAndNotebook = wait.until(ExpectedConditions.presenceOfElementLocated(hardwareAndNotebooksSelector));

        hardwareAndNotebook.click();

        By notebookOptionSelector = By.xpath("//*[@id=\"cdk-accordion-child-21\"]/div/p[2]/span");
        WebElement notebookOption = wait.until(ExpectedConditions.elementToBeClickable(notebookOptionSelector));

        notebookOption.click();

        By minimumFieldSelector = By.id("mat-input-1");
        WebElement minimumField = wait.until(ExpectedConditions.elementToBeClickable(minimumFieldSelector));

        minimumField.sendKeys("LSRSTS");

        String minimumFieldCheck = minimumField.getAttribute("value");
        if (!minimumFieldCheck.isEmpty()) {
            Assert.fail("The field is complete.");
        } else {
            System.out.println("The field is empty.");
        }
    }

    @Test(priority = 7)
    public void LettersInTheMaximumPriceFilterPDT007() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

        // Test
        By hardwareAndNotebooksSelector = By.xpath("//*[@id=\"mat-expansion-panel-header-21\"]/span/mat-panel-title");
        WebElement hardwareAndNotebook = wait.until(ExpectedConditions.presenceOfElementLocated(hardwareAndNotebooksSelector));

        hardwareAndNotebook.click();

        By notebookOptionSelector = By.xpath("//*[@id=\"cdk-accordion-child-21\"]/div/p[2]/span");
        WebElement notebookOption = wait.until(ExpectedConditions.elementToBeClickable(notebookOptionSelector));

        notebookOption.click();

        By maximumFieldSelector = By.id("mat-input-2");
        WebElement maximumField = wait.until(ExpectedConditions.elementToBeClickable(maximumFieldSelector));

        maximumField.sendKeys("LSRSTS");

        String maximumFieldCheck = maximumField.getAttribute("value");
        if (!maximumFieldCheck.isEmpty()) {
            Assert.fail("The field is complete.");
        } else {
            System.out.println("The field is empty.");
        }
    }

    @Test(priority = 8)
    public void SpecialCharactersInTheMinimumPriceFilterPDT008() throws InterruptedException {

        log.info("#######");
        log.info("[ Driver Status ] initializing");
        log.info("#######");
        driver.get(url);

        // Test
        By hardwareAndNotebooksSelector = By.xpath("//*[@id=\"mat-expansion-panel-header-21\"]/span/mat-panel-title");
        WebElement hardwareAndNotebook = wait.until(ExpectedConditions.presenceOfElementLocated(hardwareAndNotebooksSelector));

        hardwareAndNotebook.click();

        By notebookOptionSelector = By.xpath("//*[@id=\"cdk-accordion-child-21\"]/div/p[2]/span");
        WebElement notebookOption = wait.until(ExpectedConditions.elementToBeClickable(notebookOptionSelector));

        notebookOption.click();

        By minimumFieldSelector = By.id("mat-input-1");
        WebElement minimumField = wait.until(ExpectedConditions.elementToBeClickable(minimumFieldSelector));

        minimumField.sendKeys("%$@$@#$@%");

        String minimumFieldCheck = minimumField.getAttribute("value");
        if (!minimumFieldCheck.isEmpty()) {
            Assert.fail("The field is complete.");
        } else {
            System.out.println("The field is empty.");
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
