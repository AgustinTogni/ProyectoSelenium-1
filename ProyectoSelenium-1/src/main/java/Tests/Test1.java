package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\ProyectosSelinium\\ProyectoSelenium-1\\src\\main\\resources\\drivers\\chromedriver.exe");

        // Initialize browser
        WebDriver driver = new ChromeDriver();

        // Open facebook
        driver.get("https://www.maximus.com.ar/");

        // Maximize browser
        driver.manage().window().maximize();
    }
}
