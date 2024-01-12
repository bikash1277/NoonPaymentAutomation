package io.noon.pages;

import io.noon.common.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation extends CommonClass {
    public String val;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[1]/div/h2")
    public WebElement lblHeader;

    @FindBy(xpath = "//*[@id='page-wrapper']/div[2]/div[1]/div/div[1]/div/ul/li[1]/span[@class='pull-right ']")
    public WebElement txtOrderId;

    public OrderConfirmation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getValueOfOrderDetails(String substitutionValue) {
        return driver.findElement(By.xpath
                ("//*[contains(text(), '" + substitutionValue + "')]/../span[2]")).getText();
    }
}
