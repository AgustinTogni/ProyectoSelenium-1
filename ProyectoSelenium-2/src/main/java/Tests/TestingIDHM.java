package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;

import java.time.Duration;

public class TestingIDHM {

    private String url = "https://www.maximus.com.ar/";
    WebDriver chromeDriver;
    WebDriver edDriver;
    Logger log;
    WebDriverWait chromeWait;
    WebDriverWait edWait;

    @BeforeMethod
    public void setBaseConfig() {

        System.setProperty("webdriver.chrome.driver", "E:\\ProyectosSelenium\\ProyectoSelenium-2\\src\\main\\resources\\drivers\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        System.setProperty("webdriver.edge.driver", "E:\\ProyectosSelenium\\ProyectoSelenium-2\\src\\main\\resources\\drivers\\msedgedriver.exe");
        edDriver = new EdgeDriver();
        edWait = new WebDriverWait(edDriver, Duration.ofSeconds(5));

        log = LogManager.getLogger(TestingIDHM.class);

        log.info("#######");
        log.info("[ Drivers Status ] initializing");
        log.info("#######");
        chromeDriver.get(url);
        chromeDriver.manage().window().maximize();
        edDriver.get(url);
        edDriver.manage().window().maximize();
    }

    @Test(priority = 1, enabled = false)
    public void FollowMyOrderUPSBtnHM001() throws InterruptedException {}

    @Test(priority = 2, enabled = false)
    public void FollowMyOrderOCABtnHM002() throws InterruptedException {}

    @Test(priority = 3, enabled = true)
    public void UploadReceiptsBtnHM003() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "Subir Comprobantes" text is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"abircomprobantenologueado\"]")).click();

        // It is verified that "Upload Receipt window" is visible.
        WebElement uploadReceiptWindowCM = chromeDriver.findElement(By.xpath("//*[@id=\"appProfile\"]/div[3]"));
        if (uploadReceiptWindowCM.isDisplayed()) {
            System.out.println("The 'Upload Receipt Window' is visible in Chrome.");
        } else {
            Assert.fail("The 'Upload Receipt Window' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "Subir Comprobantes" text is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"abircomprobantenologueado\"]")).click();

        // It is verified that "Upload Receipt window" is visible.
        WebElement uploadReceiptWindowME = edDriver.findElement(By.xpath("//*[@id=\"appProfile\"]/div[3]"));
        if (uploadReceiptWindowME.isDisplayed()) {
            System.out.println("The 'Upload Receipt Window' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'Upload Receipt Window' isn't visible in Microsoft Edge.");
        }

    }

    @Test(priority = 4, enabled = true)
    public void WarrantyRMABtnHM004() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "RMA - Garantia" text is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[1]/a[5]/span")).click();

        //
        By warrantyRMAWindowSelectorCM = By.xpath("//*[@id=\"modaldisclaimer\"]/div/div/div[1]");
        WebElement warrantyRMAWindowCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(warrantyRMAWindowSelectorCM));

        //
        if (warrantyRMAWindowCM.isDisplayed()) {
            System.out.println("The 'RMA - Garantia window' is visible in Chrome.");
        } else {
            Assert.fail("The 'RMA - Garantia window' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "RMA - Garantia" text is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[1]/a[5]/span")).click();

        //
        By warrantyRMAWindowSelectorME = By.xpath("//*[@id=\"modaldisclaimer\"]/div/div/div[1]");
        WebElement warrantyRMAWindowME = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(warrantyRMAWindowSelectorME));

        //
        if (warrantyRMAWindowME.isDisplayed()) {
            System.out.println("The 'RMA - Garantia window' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'RMA - Garantia window' isn't visible in Microsoft Edge.");
        }
    }

    @Test(priority = 5, enabled = false)
    public void HelpBtnHM005() throws InterruptedException {}

    @Test(priority = 6, enabled = true)
    public void FindAValidProductHM006() throws InterruptedException {

        // ----- Test for Chrome -----

        // The field is complete with valid product.
        WebElement searcherCM = chromeDriver.findElement(By.id("buscadorDesktop"));
        searcherCM.sendKeys("motherboard");

        // It is verified that field is complete.
        String searcherCheckCM = searcherCM.getAttribute("value");
        if (!searcherCheckCM.isEmpty()) {
            System.out.println("The field is complete in Chrome.");
        } else {
            Assert.fail("The field is empty in Chrome.");
        }

        // The "magnifying glass" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the valid product was searched.
        WebElement motherboardResultCM = chromeDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (motherboardResultCM.isDisplayed()) {
            System.out.println("The motherboard was searched in Chrome.");
        } else {
            Assert.fail("The motherboard wasn't searched in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The field is complete with valid product.
        WebElement searcherME = edDriver.findElement(By.id("buscadorDesktop"));
        searcherME.sendKeys("motherboard");

        // It is verified that field is complete.
        String searcherCheckME = searcherME.getAttribute("value");
        if (!searcherCheckME.isEmpty()) {
            System.out.println("The field is complete in Microsoft Edge.");
        } else {
            Assert.fail("The field is empty in Microsoft Edge.");
        }

        // The "magnifying glass" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the valid product was searched.
        WebElement motherboardResultME = edDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (motherboardResultME.isDisplayed()) {
            System.out.println("The motherboard was searched in Microsoft Edge.");
        } else {
            Assert.fail("The motherboard wasn't searched in Microsoft Edge.");
        }
    }

    @Test(priority = 7, enabled = true)
    public void FindInvalidProductHM007() throws  InterruptedException {

        // ----- Test for Chrome -----

        // The field is complete with invalid product.
        WebElement searcherCM = chromeDriver.findElement(By.id("buscadorDesktop"));
        searcherCM.sendKeys("chocolate");

        // It is verified that field is complete.
        String searcherCheckCM = searcherCM.getAttribute("value");
        if (!searcherCheckCM.isEmpty()) {
            System.out.println("The field is complete in Chrome.");
        } else {
            Assert.fail("The field is empty in Chrome.");
        }

        // The "magnifying glass" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that alert "not result" is visible.
        WebElement alertResultCM = chromeDriver.findElement(By.id("contenedornoproducto"));
        if (alertResultCM.isDisplayed()) {
            System.out.println("The alert 'not result' is visible in Chrome.");
        } else {
            Assert.fail("The alert 'not result' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The field is complete with invalid product.
        WebElement searcherME = edDriver.findElement(By.id("buscadorDesktop"));
        searcherME.sendKeys("chocolate");

        // It is verified that field is complete.
        String searcherCheckME = searcherME.getAttribute("value");
        if (!searcherCheckME.isEmpty()) {
            System.out.println("The field is complete in Microsoft Edge.");
        } else {
            Assert.fail("The field is empty in Microsoft Edge.");
        }

        // The "magnifying glass" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that alert "not result" is visible.
        WebElement motherboardResultME = edDriver.findElement(By.id("contenedornoproducto"));
        if (motherboardResultME.isDisplayed()) {
            System.out.println("The alert 'not result' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The alert 'not result' isn't visible in Microsoft Edge.");
        }
    }

    @Test (priority = 8, enabled = true)
    public void SpecialCharactersInTheSearchBarHM008() throws InterruptedException {

        // ----- Test for Chrome -----

        // The field is complete with 'special characters'.
        WebElement searcherCM = chromeDriver.findElement(By.id("buscadorDesktop"));
        searcherCM.sendKeys("@#!#!@#!@#");

        // It is verified that field isn't complete.
        String searcherCheckCM = searcherCM.getAttribute("value");
        if (!searcherCheckCM.isEmpty()) {
            Assert.fail("The field is complete in Chrome.");
        } else {
            System.out.println("The field is empty in Chrome.");
        }

        // The "magnifying glass" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that alert "not result" is visible.
        WebElement alertResultCM = chromeDriver.findElement(By.id("contenedornoproducto"));
        if (alertResultCM.isDisplayed()) {
            System.out.println("The alert 'not result' is visible in Chrome.");
        } else {
            Assert.fail("The alert 'not result' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The field is complete with 'special characters'.
        WebElement searcherME = edDriver.findElement(By.id("buscadorDesktop"));
        searcherME.sendKeys("@#!#!@#!@#");

        // It is verified that field is complete.
        String searcherCheckME = searcherME.getAttribute("value");
        if (!searcherCheckME.isEmpty()) {
            Assert.fail("The field is complete in Microsoft Edge.");
        } else {
            System.out.println("The field is empty in Microsoft Edge.");
        }

        // The "magnifying glass" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that alert "not result" is visible.
        WebElement motherboardResultME = edDriver.findElement(By.id("contenedornoproducto"));
        if (motherboardResultME.isDisplayed()) {
            System.out.println("The alert 'not result' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The alert 'not result' isn't visible in Microsoft Edge.");
        }
    }

    @Test(priority = 9, enabled = true)
    public void LoginBtnHM009() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "Ingresar" text is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"cuentanologueada\"]/p")).click();

        // It is verified that "Login window" is visible.
        WebElement loginWindowCM = chromeDriver.findElement(By.id("loginBody"));
        if (loginWindowCM.isDisplayed()) {
            System.out.println("The 'login window' is visible in Chrome.");
        } else {
            Assert.fail("The 'login window' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "Ingresar" text is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"cuentanologueada\"]/p")).click();

        // It is verified that "Login window" is visible.
        WebElement loginWindowME = edDriver.findElement(By.id("loginBody"));
        if (loginWindowME.isDisplayed()) {
            System.out.println("The 'login window' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'login window' isn't visible in Microsoft Edge.");
        }
    }

    @Test(priority = 10, enabled = true)
    public void MyCartBtnHM010() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "Mi carrito" text is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[3]/a[4]/p[1]")).click();

        // Wait for cart alert to appear.
        By myCartAlertSelectorCM = By.xpath("//*[@id=\"busqueda\"]/div[3]/div");
        WebElement myCartAlertCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(myCartAlertSelectorCM));

        // It is verified "My cart alert" is visible.
        if (myCartAlertCM.isDisplayed()) {
            System.out.println("The 'My cart alert' is visible in Chrome.");
        } else {
            Assert.fail("The 'My cart alert' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "Mi carrito" text is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[3]/a[4]/p[1]")).click();

        // Wait for cart alert to appear.
        By myCartAlertSelectorME = By.xpath("//*[@id=\"busqueda\"]/div[3]/div");
        WebElement myCartAlertME = edWait.until(ExpectedConditions.visibilityOfElementLocated(myCartAlertSelectorME));

        // It is verified "My cart alert" is visible.
        if (myCartAlertME.isDisplayed()) {
            System.out.println("The 'My cart alert' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'My cart alert' isn't visible in Microsoft Edge.");
        }
    }

    @Test(priority = 11, enabled = false)
    public void SearchForCategoryHM011() throws InterruptedException {}

    @AfterMethod
    public void CloseSession(){
        log.info("#######");
        log.info("[ Drivers Status ] clean and close controller instance");
        log.info("#######");
        chromeDriver.quit();
        edDriver.quit();
    }
}
