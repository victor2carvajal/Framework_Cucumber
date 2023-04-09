package com.amazon.pages;

import com.amazon.utils.Constants;
import com.amazon.utils.Messages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    By addedProductIMG = By.xpath("//div[@class='sc-list-item-content']");
    By deleteBTN = By.xpath("//input[@data-action='delete']");
    By deletedMSG = By.xpath("//div[contains(.,'se ha eliminado del Carrito.')]/span");

    Constants constant = new Constants();
    Messages message = new Messages();

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void VerifyAdd(){

        Duration timeoutDuration = Duration.ofSeconds(constant.ten);
        WebDriverWait wait = new WebDriverWait(driver,timeoutDuration);
        WebElement AddedIMG = wait.until(ExpectedConditions.visibilityOfElementLocated(addedProductIMG));
        Assert.assertEquals(AddedIMG,AddedIMG);
    }

    public void DeleteProduct(){
        driver.findElement(deleteBTN).click();
    }

    public void VerifyDeleted(){
        String actualText = driver.findElement(deletedMSG).getText();
        Assert.assertTrue("The actual text does not contain the expected text", actualText.contains(message.deleteMSG));
    }
}
