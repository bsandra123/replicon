package com.replicon.base;

import com.github.javafaker.Faker;
import com.replicon.utility.TestRunPropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String REPLICON_URL = "https://login.replicon.com/DefaultV2.aspx";

    @BeforeClass
    public void classSetUpInBase() {
        String targetPlatform = System.getProperty("targetPlatform");
        if (targetPlatform == null || targetPlatform.equalsIgnoreCase("local")) {
            String targetBrowser = System.getProperty("targetBrowser");
            if (targetBrowser == null) {
                TestRunPropertyReader.loadTestRunProperties();
                targetBrowser = TestRunPropertyReader.getTestRunProperty("targetBrowser");
            }
            if (targetBrowser == null) {
                driver = new ChromeDriver();
            } else {
                if (targetBrowser.equalsIgnoreCase("edge")) {
                    driver = new EdgeDriver();
                } else if (targetBrowser.equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
                } else {
                    driver = new ChromeDriver();
                }
            }
        } else if (System.getProperty("targetPlatform").equalsIgnoreCase("saucelabs")) {
            SafariOptions browserOptions = new SafariOptions();
            browserOptions.setPlatformName("macOS 11.00");
            browserOptions.setBrowserVersion("14");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-bgerard7715-66df3");
            sauceOptions.put("accessKey", "8a22220f-9d2a-4606-ad34-ca5d06e57a91");
            sauceOptions.put("build", "Build-MacOS-BigSur-1");
            sauceOptions.put("name", "Test-2");
            browserOptions.setCapability("sauce:options", sauceOptions);

            // start the session
            URL url;
            try {
                url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            } catch (MalformedURLException e) {
                System.out.println("Wrong URL");
                return;
            }
            driver = new RemoteWebDriver(url, browserOptions);
        } else if (System.getProperty("targetPlatform").equalsIgnoreCase("lambda")) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("126");
            HashMap<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("username", "bgerard7715");
            ltOptions.put("accessKey", "guXEMKGbQpBfB1yKWcTqPS8jzgdfiI07qwFkVv7k7kwaVhdF73");
            ltOptions.put("project", "John-Rambo-Build-1");
            ltOptions.put("selenium_version", "4.0.0");
            ltOptions.put("w3c", true);
            browserOptions.setCapability("LT:Options", ltOptions);

            String username = "bgerard7715";
            String accesskey = "guXEMKGbQpBfB1yKWcTqPS8jzgdfiI07qwFkVv7k7kwaVhdF73";
            String gridURL = "@hub.lambdatest.com/wd/hub";

            try {
                driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        driver.get(REPLICON_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        doLogin();
    }

    public void doLogin() {
        WebElement companyName = driver.findElement(By.cssSelector("input[id=CompanyNameTextBox]"));
        companyName.sendKeys(TestRunPropertyReader.getTestRunProperty("company"));
        WebElement nextButton = driver.findElement(By.cssSelector("input[id='NextButton']"));
        nextButton.click();
        WebElement userNameField = driver.findElement(By.cssSelector("input[id='LoginNameTextBox']"));
        userNameField.sendKeys(TestRunPropertyReader.getTestRunProperty("userName"));
        WebElement password = driver.findElement(By.cssSelector("input[id='LoginNameTextBox']"));
        password.sendKeys(TestRunPropertyReader.getTestRunProperty("passcode"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='LoginButton']"));
        loginButton.click();
    }

    @AfterClass
    public void tearDownForMethodInBase() {
        pauseBrowser(1);
        driver.quit();
    }

    public void pauseBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted exception occuring during thread.sleep call.");
        }
    }
}
