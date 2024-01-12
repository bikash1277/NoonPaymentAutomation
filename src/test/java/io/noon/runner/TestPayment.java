package io.noon.runner;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPayment extends CommonRunner {


    @Test(priority = 1, description = "verifying Page Title")
    public void verifyPageTitleTest() {
        String title = commonClass.getPageTitle();
        System.out.println("the login page title is: " + title);
        Assert.assertEquals(title, "Demo Shopping Portal");
    }

    @Test(priority = 2, description = "verifying Order Details")
    public void verifyOrderInformationTest() throws InterruptedException {
        Assert.assertEquals(commonClass.getElementText(productGrid.lblEComGrid), "E-commerce Grid");
        Assert.assertTrue(commonClass.getElementText(productGrid.lblProduct).contains("Holiday Voucher"));

        productGrid.btnAddToCart.isDisplayed();
        commonClass.waitExplicit(5, productGrid.btnAddToCart);
        productGrid.btnAddToCart.click();
        commonClass.waitExplicit(5, shoppingCart.btnCheckout);


        commonClass.validateCurrentUrl("ShoppingCart");
        shoppingCart.btnCheckout.click();
        commonClass.waitExplicit(10, checkout.btnPayWithCard);
        commonClass.validateCurrentUrl("checkout");

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkout.btnMasterCard);
        checkout.lblCvv.isDisplayed();
        checkout.txtCvv.sendKeys("123");
        checkout.btnPayWithCard.click();
        Thread.sleep(10000);

        commonClass.switchToFrame("redirectTo3ds1Frame");
        commonClass.switchToFrame(auth.getFrameId());
        auth.txtChallengeData.sendKeys("1234");
        auth.btnSubmit.click();
        driver.switchTo().defaultContent();

        commonClass.waitExplicit(10, confirmation.lblHeader);
        commonClass.validateCurrentUrl("Shopping/Paid?orderID");
        Assert.assertTrue(commonClass.getElementText(confirmation.lblHeader).contains("Order & Payment Details"));

        System.out.println("Order ID is : " + confirmation.getValueOfOrderDetails("Order Id"));
        System.out.println("Order Status is : " + confirmation.getValueOfOrderDetails("Order Status"));

    }


}
