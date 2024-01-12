package io.noon.pages;

import io.noon.common.CommonClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart extends CommonClass {
    @FindBy(id = "btnCheckout")
    public
    WebElement btnCheckout;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
