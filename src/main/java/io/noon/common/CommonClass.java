package io.noon.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonClass {
    public static WebDriver driver;
    public static long LoadTimeout = 20L;
    public static long ImplicitWait = 10L;

    public static Properties prop;


    public Properties initProperty() {
        try {
            prop = new Properties();
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") +
                    "/config.properties");
            prop.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public WebDriver initBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Driver Name!!!");
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public void waitExplicit(int timeSec, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeSec));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void validateCurrentUrl(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }


    public void switchToFrame(String frameName) {

        driver.switchTo().frame(frameName);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
