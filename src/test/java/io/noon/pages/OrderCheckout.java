package io.noon.pages;

import io.noon.common.CommonClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCheckout extends CommonClass {

    @FindBy(id = "btnPayWithCard")
    public WebElement btnPayWithCard;

    @FindBy(xpath = "//*[@id='rdbSavedCard_1']")
    public WebElement btnMasterCard;

    @FindBy(xpath = "//input[@checked='checked']/../../../div[2]/div/label")
    public WebElement lblCvv;
    @FindBy(xpath = "//input[@checked='checked']/../../../div[2]/div/input")
    public WebElement txtCvv;


    public OrderCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
