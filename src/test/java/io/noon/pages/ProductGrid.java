package io.noon.pages;

import io.noon.common.CommonClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductGrid extends CommonClass {

    @FindBy(xpath = "//*[@class='col-lg-10']/h2")
    public WebElement lblEComGrid;

    @FindBy(xpath = "//*[@id='page-wrapper']/div[3]/div/div[1]/div/div/div[2]/a")
    public WebElement lblProduct;

    @FindBy(xpath = "//div/a[contains(text(),'Holiday Voucher')]/../div[2]/a[@class='btn btn-xs btn-outline btn-primary']")
    public WebElement btnAddToCart;

    public ProductGrid(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
