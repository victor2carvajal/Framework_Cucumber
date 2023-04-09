package com.amazon.pages;

import com.amazon.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {


    WebDriver driver;
    By orderByDDL = By.xpath("//select[@id='s-result-sort-select']");
    By secondProductBTN = By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[2]");
    By addToCartBTN = By.id("add-to-cart-button");
    By cartBTN = By.xpath("//a[contains(@data-csa-c-type,'button')]");
    Constants constant = new Constants();

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortBy(int index){
        Select s = new Select(driver.findElement(orderByDDL));
        s.selectByIndex(index);
    }

    public void selectProduct(){
        Duration timeoutDuration = Duration.ofSeconds(constant.ten);
        WebDriverWait wait = new WebDriverWait(driver,timeoutDuration);
        WebElement productBTN = wait.until(ExpectedConditions.elementToBeClickable(secondProductBTN));
        productBTN.click();
    }

    public void addToCart(){
        driver.findElement(addToCartBTN).click();
    }

    public void GoToCart(){
        driver.findElement(cartBTN).click();
    }
}

