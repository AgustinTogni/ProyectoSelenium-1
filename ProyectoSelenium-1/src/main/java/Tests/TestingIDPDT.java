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

        // --- Test ---

        // The browser window is maximized.
        driver.manage().window().maximize();

        // The grid mode button is clicked.
        driver.findElement(By.className("boton-inactivo")).click();

        // It is verified that the grid mode is visible.
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

        // --- Test ---

        // The "Ordenar por" button is clicked.
        driver.findElement(By.className("mat-select-arrow-wrapper")).click();

        // The "Destacados" filter is clicked.
        List<WebElement> options = driver.findElements(By.className("mat-option-text"));

        boolean actionPerformed = false;
        for (WebElement featuredOption : options) {
            if (featuredOption.getText().equals("Destacados")) {
                featuredOption.click();
                actionPerformed = true;
                break;
            }
        }

        // It is verified the featured filter is on.
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

        // --- Test ---

        // The "Ordenar por" button is clicked.
        driver.findElement(By.className("mat-select-arrow-wrapper")).click();

        // The "Mayor precio" filter is clicked.
        List<WebElement> options = driver.findElements(By.className("mat-option-text"));

        boolean actionPerformed = false;
        for (WebElement featuredOption : options) {
            if (featuredOption.getText().equals("Mayor precio")) {
                featuredOption.click();
                actionPerformed = true;
                break;
            }
        }

        // It is verified the higher price filter is on.
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

        // --- Test ---

        // The browser windows is maximize.
        driver.manage().window().maximize();

        // The "INICIAR SESION" button is clicked.
        driver.findElement(By.className("mat-button-wrapper")).click();

        // The field is complete with email.
        driver.findElement(By.cssSelector("div.ng-tns-c103-4 input.mat-input-element")).sendKeys(email);

        // The "CONTINUAR" button is clicked.
        driver.findElement(By.className("continue")).click();

        // Wait for field to appear.
        By passwordSelector = By.cssSelector("div.ng-tns-c103-6 input.mat-input-element");
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(passwordSelector));

        // The field is complete with password.
        passwordInput.sendKeys(password);

        // The "INGRESAR" button is clicked for the location.
        WebElement enterBtn = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/cgw-dialog-modal/div/cgw-login/div/div/div/button[1]/span"));

        Point location = enterBtn.getLocation();
        int positionX = location.getX();
        int positionY = location.getY();

        Actions actions = new Actions(driver);
        actions.moveByOffset(positionX, positionY).click().build().perform();

        // The "PRODUCTOS" section is clicked.
        driver.findElement(By.id("productos")).click();

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // The "AGREGAR AL CARRITO" button is clicked.
        btnAddToCart.click();

        // It is verified that the product was to cart.
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

        // --- Test ---

        // The browser windows is maximize.
        driver.manage().window().maximize();

        // The "INICIAR SESION" button is clicked.
        driver.findElement(By.className("mat-button-wrapper")).click();

        // The field is complete with email.
        driver.findElement(By.cssSelector("div.ng-tns-c103-4 input.mat-input-element")).sendKeys(email);

        // The "CONTINUAR" button is clicked.
        driver.findElement(By.className("continue")).click();

        // Wait for field to appear.
        By passwordSelector = By.cssSelector("div.ng-tns-c103-6 input.mat-input-element");
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(passwordSelector));

        // The field is complete with password.
        passwordInput.sendKeys(password);

        // The "INGRESAR" button is clicked for the location.
        WebElement enterBtn = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/cgw-dialog-modal/div/cgw-login/div/div/div/button[1]/span"));

        Point location = enterBtn.getLocation();
        int positionX = location.getX();
        int positionY = location.getY();

        Actions actions = new Actions(driver);
        actions.moveByOffset(positionX, positionY).click().build().perform();

        // The "PRODUCTOS" section is clicked.
        driver.findElement(By.id("productos")).click();

        // Wait for "AGREGAR AL CARRITO" to appear.
        By btnAddToCartSelector = By.xpath("//*[@id=\"productos-container\"]/div/div/div/cgw-products-list/div/div[2]/div[2]/div/cgw-product-alone[1]/div/div[2]/div[3]/button");
        WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCartSelector));

        // Infinite clicks on the "AGREGAR AL CARRITO" button.
        while (btnAddToCart.isEnabled()) {
            btnAddToCart.click();
        }

        // It is verified the button is off.
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

        // --- Test ---

        // Wait for hardware and notebook section to appear.
        By hardwareAndNotebooksSelector = By.xpath("//*[@id=\"mat-expansion-panel-header-21\"]/span/mat-panel-title");
        WebElement hardwareAndNotebook = wait.until(ExpectedConditions.presenceOfElementLocated(hardwareAndNotebooksSelector));

        // The hardware and notebook button is clicked.
        hardwareAndNotebook.click();

        // Wait for notebook option to appear.
        By notebookOptionSelector = By.xpath("//*[@id=\"cdk-accordion-child-21\"]/div/p[2]/span");
        WebElement notebookOption = wait.until(ExpectedConditions.elementToBeClickable(notebookOptionSelector));

        // The notebook option is clicked.
        notebookOption.click();

        // Wait for minimum field to appear.
        By minimumFieldSelector = By.id("mat-input-1");
        WebElement minimumField = wait.until(ExpectedConditions.elementToBeClickable(minimumFieldSelector));

        // The field is complete with letters.
        minimumField.sendKeys("LSRSTS");

        // It is verified that the field is complete.
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

        // --- Test ---

        // Wait for hardware and notebook section to appear.
        By hardwareAndNotebooksSelector = By.xpath("//*[@id=\"mat-expansion-panel-header-21\"]/span/mat-panel-title");
        WebElement hardwareAndNotebook = wait.until(ExpectedConditions.presenceOfElementLocated(hardwareAndNotebooksSelector));

        // The hardware and notebook button is clicked.
        hardwareAndNotebook.click();

        // Wait for notebook option to appear.
        By notebookOptionSelector = By.xpath("//*[@id=\"cdk-accordion-child-21\"]/div/p[2]/span");
        WebElement notebookOption = wait.until(ExpectedConditions.elementToBeClickable(notebookOptionSelector));

        // The notebook option is clicked.
        notebookOption.click();

        // Wait for maximum field to appear.
        By maximumFieldSelector = By.id("mat-input-2");
        WebElement maximumField = wait.until(ExpectedConditions.elementToBeClickable(maximumFieldSelector));

        // The field is complete with letters.
        maximumField.sendKeys("LSRSTS");

        // It is verified that the field is complete.
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

        // --- Test ---

        // Wait for hardware and notebook section to appear.
        By hardwareAndNotebooksSelector = By.xpath("//*[@id=\"mat-expansion-panel-header-21\"]/span/mat-panel-title");
        WebElement hardwareAndNotebook = wait.until(ExpectedConditions.presenceOfElementLocated(hardwareAndNotebooksSelector));

        // The hardware and notebook button is clicked.
        hardwareAndNotebook.click();

        // Wait for notebook option to appear.
        By notebookOptionSelector = By.xpath("//*[@id=\"cdk-accordion-child-21\"]/div/p[2]/span");
        WebElement notebookOption = wait.until(ExpectedConditions.elementToBeClickable(notebookOptionSelector));

        // The notebook option is clicked.
        notebookOption.click();

        // Wait for minimum field to appear.
        By minimumFieldSelector = By.id("mat-input-1");
        WebElement minimumField = wait.until(ExpectedConditions.elementToBeClickable(minimumFieldSelector));

        // The field is complete with special characters.
        minimumField.sendKeys("%$@$@#$@%");

        // It is verified that the field is complete.
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
