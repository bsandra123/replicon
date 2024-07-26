package com.replicon.base;

import com.replicon.utility.TestRunPropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void classSetUpInBase() {

        String browser = TestRunPropertyReader.readProperties("browser");
        if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incongnito");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pauseBrowser(4);
        driver.get(TestRunPropertyReader.readProperties("url"));
        doLogin();

    }

    public void doLogin() {
        pauseBrowser(3);
        WebElement companyName = driver.findElement(By.cssSelector("input[id=CompanyNameTextBox]"));
        companyName.sendKeys(TestRunPropertyReader.readProperties("company"));
        WebElement nextButton = driver.findElement(By.cssSelector("input[id='NextButton']"));
        nextButton.click();

        pauseBrowser(3);

        WebElement userNameField = driver.findElement(By.cssSelector("input[id='LoginNameTextBox']"));
        userNameField.clear();
        userNameField.sendKeys(TestRunPropertyReader.readProperties("userName"));

        WebElement passwordField = driver.findElement(By.cssSelector("input[id='PasswordTextBox']"));
        passwordField.clear();
        passwordField.sendKeys(TestRunPropertyReader.readProperties("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='LoginButton']"));

        loginButton.click();
        pauseBrowser(3);
    }

    @AfterClass
    public void tearDownForMethodInBase() {
        pauseBrowser(1);
        driver.quit();
    }

    @AfterMethod
    public void goToMenuPage() {
        WebElement returnToMenu = driver.findElement(By.cssSelector("a[id='substituteBannerActionButton']"));
        returnToMenu.click();
    }

    public void pauseBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted exception occuring during thread.sleep call.");
        }
    }
}
