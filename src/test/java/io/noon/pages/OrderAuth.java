package io.noon.pages;

import io.noon.common.CommonClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAuth extends CommonClass {

    @FindBy(xpath = "//*[@id='content']/div[2]/form[1]/input[1]")
    public WebElement txtChallengeData;

    @FindBy(xpath = "//input[@class='button primary']")
    public WebElement btnSubmit;

    @FindBy(xpath = "/html/body/div[1]/div/iframe")
    public WebElement iFrame;

    @FindBy(xpath = "//*[@id='redirectTo3ds1Frame']")
    public WebElement iFrameParent;

    public OrderAuth(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFrameId() {
        return iFrame.getAttribute("id");
    }
}
