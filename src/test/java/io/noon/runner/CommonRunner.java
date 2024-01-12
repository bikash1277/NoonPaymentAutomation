package io.noon.runner;

import io.noon.common.CommonClass;
import io.noon.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class CommonRunner {

    public WebDriver driver;
    public Properties prop;
    public ProductGrid productGrid;
    public ShoppingCart shoppingCart;
    public OrderCheckout checkout;
    public OrderAuth auth;
    public OrderConfirmation confirmation;
    CommonClass commonClass;

    @BeforeSuite // this method will be executed before every @Suite method
    @Parameters("browser")
    public void setUp(String browser) {
        commonClass = new CommonClass();
        prop = commonClass.initProperty();
        driver = commonClass.initBrowser(browser);
        driver.get(prop.getProperty("url"));
        productGrid = new ProductGrid(driver);
        shoppingCart = new ShoppingCart(driver);
        checkout = new OrderCheckout(driver);
        auth = new OrderAuth(driver);
        confirmation = new OrderConfirmation(driver);
    }

    @AfterSuite
    public void tearDown() {
        commonClass.closeBrowser();
    }
}
